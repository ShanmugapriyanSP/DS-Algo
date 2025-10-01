package com.data.structures.algorithms.java.lld.elevator.v1.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Floor implements Comparable {
    private static final Map<Integer, Floor> map = new HashMap<>();
    private final Integer number;
    private Floor(int number) {
        this.number = number;
    }

    public Integer number() {
        return number;
    }

    public static synchronized Floor get(int number) {
        map.putIfAbsent(number, new Floor(number));
        return map.get(number);
    }

    public synchronized Floor increment() {
        return get(this.number+1);
    }

    public synchronized Floor decrement() {
        return get(this.number-1);
    }

    @Override
    public String toString() {
        return this.number.toString();
    }

    @Override
    public int compareTo(Object obj) {
        Floor floor = (Floor) obj;
        return this.number.compareTo(floor.number());
    }

    @Override
    public boolean equals(Object obj) {
        Floor floor = (Floor) obj;
        return Objects.equals(this.number, floor.number());
    }
}
