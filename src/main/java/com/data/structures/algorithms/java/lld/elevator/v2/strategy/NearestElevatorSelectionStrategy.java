package com.data.structures.algorithms.java.lld.elevator.v2.strategy;

import com.data.structures.algorithms.java.lld.elevator.v2.Elevator;
import com.data.structures.algorithms.java.lld.elevator.v2.enums.Direction;
import com.data.structures.algorithms.java.lld.elevator.v2.models.Request;

import java.util.List;
import java.util.Optional;

public class NearestElevatorSelectionStrategy implements ElevationSelectionStrategy {

    @Override
    public Optional<Elevator> selectElevator(List<Elevator> elevators, Request request) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator: elevators) {
            if (isSuitable(elevator, request)) {
                int distance = Math.abs(elevator.getCurrentFloor() - request.targetFloor());
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }

        return Optional.ofNullable(bestElevator);
    }

    private boolean isSuitable(Elevator elevator, Request request) {
        if (elevator.getDirection() == Direction.IDLE)
            return true;
        if (request.direction() == elevator.getDirection()) {
            return (elevator.getDirection() == Direction.UP && elevator.getCurrentFloor() < request.targetFloor()) ||
                    elevator.getDirection() == Direction.DOWN && elevator.getCurrentFloor() > request.targetFloor();
        }
        return false;
    }
}
