package com.data.structures.algorithms.java.lld.elevator.v2;

import com.data.structures.algorithms.java.lld.elevator.v2.enums.Direction;
import com.data.structures.algorithms.java.lld.elevator.v2.models.Request;
import com.data.structures.algorithms.java.lld.elevator.v2.observers.ElevatorObserver;
import com.data.structures.algorithms.java.lld.elevator.v2.state.ElevatorState;
import com.data.structures.algorithms.java.lld.elevator.v2.state.IdleState;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Elevator implements Runnable {

    private final int id;
    private AtomicInteger currentFloor;
    private List<ElevatorObserver> observers;
    private ElevatorState state;
    private boolean isRunning = false;
    private final TreeSet<Integer> upRequests;
    private final TreeSet<Integer> downRequests;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = new AtomicInteger(0);
        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>((a, b) -> b - a);
        this.state = new IdleState();
        this.observers = new ArrayList<>();
    }

    public void addObserver(ElevatorObserver observer) {
        this.observers.add(observer);
        observer.update(this);
    }

    public void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }

    public void setState(ElevatorState state) {
        this.state = state;
        notifyObservers();
    }

    public int getCurrentFloor() {
        return this.currentFloor.get();
    }

    public Direction getDirection() {
        return this.state.getDirection();
    }

    public void setCurrentFloor(int floor) {
        currentFloor.set(floor);
        notifyObservers();
    }

    public void stopElevator() {
        this.isRunning = false;
    }

    public synchronized void addRequest(Request request) {
        System.out.println("Elevator " + id + " processing: " + request);
        this.state.addRequest(this, request);
    }

    @Override
    public void run() {
        while(isRunning) {
            this.state.move(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                isRunning = false;
            }
        }
    }
}
