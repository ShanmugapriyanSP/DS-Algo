package com.data.structures.algorithms.java.design.patterns.creational.singleton;

public enum EnumSingleton {

    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
