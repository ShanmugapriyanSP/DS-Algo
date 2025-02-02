package com.data.structures.algorithms.java.design.patterns.behavioral.template;

public class WoodenHouse extends HouseTemplate{

    @Override
    public void buildPillars() {
        System.out.println("Building Wooden pillars..");
    }

    @Override
    public void buildWalls() {
        System.out.println("Building Wooden walls..");
    }
}
