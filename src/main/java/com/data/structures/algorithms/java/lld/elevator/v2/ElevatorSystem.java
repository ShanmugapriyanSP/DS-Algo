package com.data.structures.algorithms.java.lld.elevator.v2;

import com.data.structures.algorithms.java.lld.elevator.v2.enums.Direction;
import com.data.structures.algorithms.java.lld.elevator.v2.enums.RequestSource;
import com.data.structures.algorithms.java.lld.elevator.v2.models.Request;
import com.data.structures.algorithms.java.lld.elevator.v2.observers.Display;
import com.data.structures.algorithms.java.lld.elevator.v2.observers.ElevatorObserver;
import com.data.structures.algorithms.java.lld.elevator.v2.strategy.ElevationSelectionStrategy;
import com.data.structures.algorithms.java.lld.elevator.v2.strategy.NearestElevatorSelectionStrategy;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ElevatorSystem {

    private static ElevatorSystem instance;
    private final Map<Integer, Elevator> elevators;
    private final ExecutorService executorService;
    private final ElevationSelectionStrategy selectionStrategy;

    private ElevatorSystem(int numOfElevators) {
        executorService = Executors.newFixedThreadPool(numOfElevators);
        selectionStrategy = new NearestElevatorSelectionStrategy();
        ElevatorObserver elevatorDisplay = new Display();
        elevators = IntStream.rangeClosed(1, numOfElevators)
                .mapToObj(i -> {
                        Elevator elevator = new Elevator(i);
                        elevator.addObserver(elevatorDisplay);
                        return elevator;
                    })
                .collect(Collectors.toMap(Elevator::getId, e -> e));
    }

    public static synchronized ElevatorSystem getInstance(int numElevators) {
        if (instance == null) {
            instance = new ElevatorSystem(numElevators);
        }
        return instance;
    }

    public void start() {
        elevators.values().forEach(executorService::execute);
    }

    public void requestElevator(int floor, Direction direction) {
        System.out.println("\n>> EXTERNAL Request: User at floor " + floor + " wants to go " + direction);
        Request request = new Request(direction, RequestSource.EXTERNAL, floor);

        Optional<Elevator> elevator = selectionStrategy.selectElevator(new ArrayList<>(elevators.values()), request);
        if (elevator.isPresent()) {
            elevator.get().addRequest(request);
        } else {
            System.out.println("Elevators are busy... Please wait!!");
        }
    }

    public void selectFloor(int elevatorId, int floor) {
        System.out.println("\n>> INTERNAL Request: User in Elevator " + elevatorId + " selected floor " + floor);
        Request request = new Request(Direction.IDLE, RequestSource.INTERNAL, floor);
        elevators.get(elevatorId).addRequest(request);
    }

    public void shutdown() {
        System.out.println("Shutting down elevator system...");
        elevators.values().forEach(Elevator::stopElevator);
        executorService.shutdown();
    }
}
