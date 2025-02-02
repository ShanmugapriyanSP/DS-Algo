package com.data.structures.algorithms.java.design.patterns.structural.facade;

public class Projector implements SubSystem {

    public void on() { System.out.println("Projector is ON"); }
    public void setInput(String source) { System.out.println("Projector input set to: " + source); }
    public void off() { System.out.println("Projector is OFF"); }
}
