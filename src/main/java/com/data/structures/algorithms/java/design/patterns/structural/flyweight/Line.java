package com.data.structures.algorithms.java.design.patterns.structural.flyweight;

import java.awt.*;

public class Line implements JShape {


    @Override
    public void draw(Graphics line, int x, int y, int width, int height, Color color) {
        line.setColor(color);
    }
}
