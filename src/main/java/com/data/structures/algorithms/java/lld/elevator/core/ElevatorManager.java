package com.data.structures.algorithms.java.lld.elevator.core;

import com.data.structures.algorithms.java.lld.elevator.enums.Direction;
import com.data.structures.algorithms.java.lld.elevator.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class ElevatorManager {

    private static final Logger logger = LoggerFactory.getLogger(ElevatorManager.class);
    private static ElevatorManager instance;
    private static final ReentrantLock lock = new ReentrantLock();

    private final Set<Elevator> elevators;
    private final ConcurrentMap<FloorRequestKey, List<Request>> requestConcurrentMap;

    private ElevatorManager() {
        this.elevators = new HashSet<>();
        this.requestConcurrentMap = new ConcurrentHashMap<>();
        Thread.ofPlatform().start(this::displayStats);
    }

    public static ElevatorManager getInstance() {
        if (instance == null) {
            synchronized (ElevatorManager.class) {
                instance = new ElevatorManager();
            }
        }
        return instance;
    }

    public static ElevatorManager getInstance(Elevator elevator) {
        if (instance == null) {
            synchronized (ElevatorManager.class) {
                instance = new ElevatorManager();
            }
        }
        instance.elevators.add(elevator);
        return instance;
    }

    public void startElevator(Elevator elevator) {
        new Thread(elevator::run).start();
    }

    public boolean hasRequests() {
        return this.requestConcurrentMap.values().stream().anyMatch(capacity -> !capacity.isEmpty());
    }

    public void requestElevator(People people, SimpleEntry<Floor, Floor> pair) {
        logger.info("{} - Source: {}, Destination: {}", people.name(), pair.getKey(), pair.getValue());
        Request request = new Request(people, pair.getKey(), pair.getValue());
        FloorRequestKey floorRequestKey = new FloorRequestKey(pair.getKey(), request.direction());
        requestConcurrentMap.computeIfAbsent(floorRequestKey, key -> new ArrayList<>()).add(request);
        Thread.ofVirtual().start(() -> this.notifyElevators(floorRequestKey));
    }

    public List<Request> receivePeopleByDirection(Floor floor, Direction direction, int capacity) {
        List<Request> requests = new ArrayList<>();
        try{
            lock.lock();
            List<FloorRequestKey> requestKeys = filterRequestByFloorAndDirection(floor, direction);
            if (!requestKeys.isEmpty()) {
                requests = this.requestConcurrentMap.get(requestKeys.getFirst()).stream()
                        .limit(capacity).toList();
                this.requestConcurrentMap.get(requestKeys.getFirst()).removeAll(requests);
            }
        } finally {
            lock.unlock();
        }
        return requests;
    }

    private List<FloorRequestKey> filterRequestByFloorAndDirection(Floor floor, Direction direction) {
        return this.requestConcurrentMap.keySet().stream()
                .filter(key -> key.floor() == floor && key.direction() == direction).toList();
    }

    private void notifyElevators(FloorRequestKey floorRequestKey) {
        List<Elevator> nearestElevators = elevators.stream()
                .filter(elevator -> !elevator.isMoving())
                .sorted(Comparator.comparingInt(e -> Math.abs(e.getCurrentFloor().number() - floorRequestKey.floor().number())))
                .toList();
        int totalRequests = this.requestConcurrentMap.get(floorRequestKey).size();
        for(Elevator elevator: nearestElevators) {
            if (elevator.getCurrentCapacity() > 0) {
                logger.info("Calling Lift - {}", elevator.getId());
                elevator.nudge();
                totalRequests -= elevator.getCurrentCapacity();
            }
            if (totalRequests <= 0)
                break;
        }
    }
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("====================\nLift Status\n=====================\n");
        elevators.forEach(e -> stringBuffer.append(e.toString() + "\n"));
        stringBuffer.append("====================\nPeople Status\n=====================\n");
        this.requestConcurrentMap.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Request::source, Collectors.counting()))  // Group by source (floor) and count
                .forEach((floor, count) -> stringBuffer.append("Floor " + floor + ": " + count + " requests\n"));
        return stringBuffer.toString();
    }

    private void displayStats() {
        while(true) {
            System.out.print(this);
            try {
                Thread.sleep(10 * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
