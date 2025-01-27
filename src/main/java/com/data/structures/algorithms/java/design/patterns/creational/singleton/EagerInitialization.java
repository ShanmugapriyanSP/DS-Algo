package com.data.structures.algorithms.java.design.patterns.creational.singleton;

public class EagerInitialization {


    private static final EagerInitialization instance = new EagerInitialization();

    private EagerInitialization() {}

    // Eager
    public static EagerInitialization getInstance() {
        return instance;
    }

}
