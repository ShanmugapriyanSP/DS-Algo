package com.data.structures.algorithms.java.design.patterns.structural.bridge;

public class Radio implements Device{

    public void on() {
        System.out.println("Radio is ON");
    }

    public void off() {
        System.out.println("Radio is OFF");
    }

    public void setVolume(int volume) {
        System.out.println("Setting volume to " + volume + " on Radio");
    }
}
