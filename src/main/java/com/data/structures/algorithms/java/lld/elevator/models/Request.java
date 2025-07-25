package com.data.structures.algorithms.java.lld.elevator.models;

import com.data.structures.algorithms.java.lld.elevator.enums.Direction;
import com.data.structures.algorithms.java.lld.elevator.exception.InvalidRequest;

public record Request(People people, Floor source, Floor destination, Direction direction) {
    public Request(People people, Floor source, Floor destination) {
        this(people, source, destination, getDirection(source, destination));
    }

    public static Direction getDirection(Floor source, Floor destination) {
        if (source == destination) {
            throw new InvalidRequest("Source and destination floor are same");
        }
        return source.number() > destination.number() ? Direction.DOWN : Direction.UP;
    }
}
