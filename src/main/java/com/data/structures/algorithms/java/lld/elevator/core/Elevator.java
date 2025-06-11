package com.data.structures.algorithms.java.lld.elevator.core;

import com.data.structures.algorithms.java.lld.elevator.enums.Direction;
import com.data.structures.algorithms.java.lld.elevator.models.Floor;
import com.data.structures.algorithms.java.lld.elevator.models.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;


public class Elevator {

    private static final Logger logger = LoggerFactory.getLogger(Elevator.class);
    private static final ReentrantLock lock = new ReentrantLock();
    private final int id;
    private final int maxCapacity;
    private Floor currentFloor;
    private Direction currentDirection;
    private final BlockingQueue<Floor> floorQueue;
    private volatile Boolean isMoving;
    private final List<Request> currentRequests;
    private final ElevatorManager elevatorManager;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.maxCapacity = capacity;
        this.currentFloor = Floor.get(0);
        this.currentRequests = Collections.synchronizedList(new ArrayList<>());
        this.floorQueue = new LinkedBlockingQueue<>();
        this.isMoving = Boolean.FALSE;
        this.currentDirection = Direction.UP;
        this.elevatorManager = ElevatorManager.getInstance(this);
    }

    public void run() {
        processRequests();
    }

    public int getId() {
        return this.id;
    }

    public Floor getCurrentFloor() {
        return this.currentFloor;
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    public Boolean isMoving() {
        return this.isMoving;
    }

    public int getCurrentCapacity() {
        return this.maxCapacity - this.currentRequests.size();
    }

    public synchronized void nudge() {
        isMoving = true;
        notifyAll();
    }

    public synchronized void processRequests() {
        while(true) {
            while (this.elevatorManager.hasRequests()) {
                simulateMovementAndPickUpDropPeople();
            }
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
    }

    private void simulateMovementAndPickUpDropPeople() {
       while (elevatorManager.hasRequests() || !currentRequests.isEmpty()) {
           isMoving = true;
           simulateMovement(1);
           this.currentFloor = currentDirection == Direction.UP ? currentFloor.increment() : currentFloor.decrement();
           dropPeople();
           pickUpPeople();
           flipDirectionIfRequestInOppositeWay();
       }
       isMoving = false;
    }

    private synchronized void pickUpPeople() {
        Direction directionRequest = currentDirection;
        if (currentFloor.number() == 0) {
            directionRequest = Direction.UP;
        } else if (currentFloor.number() == 10) {
            directionRequest = Direction.DOWN;
        }

        List<Request> requests = this.elevatorManager.receivePeopleByDirection(this.currentFloor, directionRequest, getCurrentCapacity());
        if (requests.isEmpty())
            return;

        logger.info("Lift {}: Picked up {} people from {} floor", id, requests.size(), this.currentFloor.number());
        this.currentRequests.addAll(requests);
    }

    private synchronized void dropPeople() {
        List<Request> requests = this.currentRequests.stream()
                .filter(req -> req.destination().number() == this.currentFloor.number())
                .peek(req -> logger.info("Lift {}: Floor: {} -" +
                        " Dropping people -> {}", this.id, this.currentFloor.number(), req.people().name()))
                .toList();
        if (!requests.isEmpty())
            this.currentRequests.removeAll(requests);
    }

    private void simulateMovement(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void flipDirectionIfRequestInOppositeWay() {
        if (currentFloor.number() == 0 || currentFloor.number() == 10) {
            flipDirection();
            return;
        }
        boolean requestDirection = false;
        if (!currentRequests.isEmpty())
            requestDirection = currentRequests.stream()
                    .noneMatch(req -> req.direction() == this.currentDirection);
        if (requestDirection)
            flipDirection();
    }

    private void flipDirection() {
        this.currentDirection = this.currentDirection == Direction.UP? Direction.DOWN : Direction.UP;
        logger.info("Lift {}: Flipping direction to {}", id, currentDirection.name());
    }

    @Override
    public String toString() {
        return String.format("Lift %d: Floor: %s, Direction: %s, PeopleCount: %d, Moving: %b",
                id, this.currentFloor, this.currentDirection.name(), this.currentRequests.size(), isMoving());
    }
}
