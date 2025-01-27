package com.data.structures.algorithms.java.design.patterns.structural.adapter;

public class Socket {

    public Volt getVolt() {
        return new Volt(120);
    }
}
