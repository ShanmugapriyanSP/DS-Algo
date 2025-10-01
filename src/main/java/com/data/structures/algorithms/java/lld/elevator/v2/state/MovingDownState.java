package com.data.structures.algorithms.java.lld.elevator.v2.state;

import com.data.structures.algorithms.java.lld.elevator.v2.Elevator;
import com.data.structures.algorithms.java.lld.elevator.v2.enums.Direction;
import com.data.structures.algorithms.java.lld.elevator.v2.enums.RequestSource;
import com.data.structures.algorithms.java.lld.elevator.v2.models.Request;

public class MovingDownState extends ElevatorState {


    @Override
    public void addRequest(Elevator elevator, Request request) {
        if (request.source() == RequestSource.INTERNAL) {
            super.addRequest(elevator, request);
            return;
        }

        if (request.direction() == Direction.DOWN && request.targetFloor() <= elevator.getCurrentFloor()) {
            elevator.getDownRequests().add(request.targetFloor());
        } else if (request.direction() == Direction.UP) {
            elevator.getUpRequests().add(request.targetFloor());
        }
    }

    @Override
    public Direction getDirection() {
        return Direction.DOWN;
    }

    @Override
    public void move(Elevator elevator) {
        if (elevator.getDownRequests().isEmpty()) {
            elevator.setState(new IdleState());
            return;
        }

        Integer nextFloor = elevator.getDownRequests().first();
        elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);

        if (elevator.getCurrentFloor() == nextFloor) {
            System.out.println("Elevator " + elevator.getId() + " stopped at floor " + nextFloor);
            elevator.getDownRequests().pollFirst();
        }

        if (elevator.getDownRequests().isEmpty()) {
            elevator.setState(new IdleState());
        }
    }
}
