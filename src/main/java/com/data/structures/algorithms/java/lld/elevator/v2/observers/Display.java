package com.data.structures.algorithms.java.lld.elevator.v2.observers;

import com.data.structures.algorithms.java.lld.elevator.v2.Elevator;

public class Display implements ElevatorObserver {

    @Override
    public void update(Elevator elevator) {
        System.out.println("[DISPLAY] Elevator: " + elevator.getId() + "| Direction: " + elevator.getDirection() +
                " | Floor: " + elevator.getCurrentFloor());
    }
}
