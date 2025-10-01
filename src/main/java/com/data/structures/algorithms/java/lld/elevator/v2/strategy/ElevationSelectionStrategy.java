package com.data.structures.algorithms.java.lld.elevator.v2.strategy;

import com.data.structures.algorithms.java.lld.elevator.v2.Elevator;
import com.data.structures.algorithms.java.lld.elevator.v2.models.Request;

import java.util.List;
import java.util.Optional;

public interface ElevationSelectionStrategy {
    Optional<Elevator> selectElevator(List<Elevator> elevators, Request request);
}
