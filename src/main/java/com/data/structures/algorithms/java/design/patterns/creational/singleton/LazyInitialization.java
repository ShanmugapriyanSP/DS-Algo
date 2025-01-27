package com.data.structures.algorithms.java.design.patterns.creational.singleton;


public class LazyInitialization {

    private static LazyInitialization instance;

    private LazyInitialization() {}

    // Lazy initialization + Thread safe
    private static synchronized LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }


    // Lazy + double locking thread safe
    public static LazyInitialization getInstanceDoubleLocking() {
        if (instance == null) {
            synchronized (LazyInitialization.class) {
                instance = new LazyInitialization();
            }
        }
        return instance;
    }

}
