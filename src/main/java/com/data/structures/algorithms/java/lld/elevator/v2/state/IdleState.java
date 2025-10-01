package com.data.structures.algorithms.java.lld.elevator.v2.state;

import com.data.structures.algorithms.java.lld.elevator.v2.Elevator;
import com.data.structures.algorithms.java.lld.elevator.v2.enums.Direction;
import com.data.structures.algorithms.java.lld.elevator.v2.models.Request;

public class IdleState extends ElevatorState {

    @Override
    public void addRequest(Elevator elevator, Request request) {
        super.addRequest(elevator, request);
    }

    @Override
    public Direction getDirection() {
        return Direction.IDLE;
    }

    @Override
    public void move(Elevator elevator) {
        if (!elevator.getDownRequests().isEmpty()) {
            elevator.setState(new MovingDownState());
        } else if (!elevator.getUpRequests().isEmpty()) {
            elevator.setState(new MovingUpState());
        }
    }
}
