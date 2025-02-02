package com.data.structures.algorithms.java.design.patterns.structural.facade;

public class Amplifier implements SubSystem {
    public void on() { System.out.println("Amplifier is ON"); }
    public void setVolume(int level) { System.out.println("Amplifier volume set to " + level); }
    public void off() { System.out.println("Amplifier is OFF"); }
}
