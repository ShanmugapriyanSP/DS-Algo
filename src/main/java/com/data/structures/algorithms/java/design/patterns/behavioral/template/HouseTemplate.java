package com.data.structures.algorithms.java.design.patterns.behavioral.template;

public abstract class HouseTemplate {


    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildPillars();
        buildWindows();
        System.out.println("House is built");
    }

    private void buildFoundation() {
        System.out.println("Building foundation...");
    }

    public abstract void buildWalls();

    public abstract void buildPillars();

    private void buildWindows() {
        System.out.println("Building Windows....");
    }
}
