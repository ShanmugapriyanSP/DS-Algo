package com.data.structures.algorithms.java.design.patterns.structural.bridge;

public class TV implements Device {

    public void on() {
        System.out.println("TV is ON");
    }

    public void off() {
        System.out.println("TV is OFF");
    }

    public void setVolume(int volume) {
        System.out.println("Setting volume to " + volume + " on TV");
    }
}
