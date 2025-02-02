package com.data.structures.algorithms.java.design.patterns.behavioral.template;

public class GlassHouse extends HouseTemplate{

    @Override
    public void buildPillars() {
        System.out.println("Building Glass pillars..");
    }

    @Override
    public void buildWalls() {
        System.out.println("Building Glass walls..");
    }
}
