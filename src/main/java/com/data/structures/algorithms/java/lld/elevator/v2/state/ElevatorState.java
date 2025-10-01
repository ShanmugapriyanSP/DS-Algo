package com.data.structures.algorithms.java.lld.elevator.v2.state;

import com.data.structures.algorithms.java.lld.elevator.v2.Elevator;
import com.data.structures.algorithms.java.lld.elevator.v2.enums.Direction;
import com.data.structures.algorithms.java.lld.elevator.v2.models.Request;

public abstract class ElevatorState {

    public void addRequest(Elevator elevator, Request request) {
        if (elevator.getCurrentFloor() > request.targetFloor()) {
            elevator.getDownRequests().add(request.targetFloor());
        } else if (elevator.getCurrentFloor() < request.targetFloor()) {
            elevator.getUpRequests().add(request.targetFloor());
        }
    }

    public abstract Direction getDirection();

    public abstract void move(Elevator elevator);
}
