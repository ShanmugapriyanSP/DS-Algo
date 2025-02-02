package com.data.structures.algorithms.java.design.patterns.structural.facade;

public class Lights implements SubSystem{

    public void dim(int level) { System.out.println("Lights dimmed to " + level + "%"); }
    public void on() { System.out.println("Lights are ON"); }
    public void off() { System.out.println("Lights are OFF"); }
}
