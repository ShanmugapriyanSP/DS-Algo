package com.data.structures.algorithms.java.lld.elevator.v2.models;

import com.data.structures.algorithms.java.lld.elevator.v2.enums.Direction;
import com.data.structures.algorithms.java.lld.elevator.v2.enums.RequestSource;

public record Request(Direction direction, RequestSource source, int targetFloor) {

}
