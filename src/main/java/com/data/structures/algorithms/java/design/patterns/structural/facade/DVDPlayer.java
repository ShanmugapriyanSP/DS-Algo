package com.data.structures.algorithms.java.design.patterns.structural.facade;

public class DVDPlayer implements SubSystem {

    public void on() {
        System.out.println("DVDPlayer is on");
    }

    public void off() {
        System.out.println("DVDPlayer is off");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("Stopping DVDPlayer...");
    }
}
