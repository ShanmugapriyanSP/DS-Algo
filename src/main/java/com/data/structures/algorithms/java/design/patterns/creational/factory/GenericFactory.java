package com.data.structures.algorithms.java.design.patterns.creational.factory;

public class GenericFactory {

    public static <T> T getInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown Value!!");
        }
    }
}
