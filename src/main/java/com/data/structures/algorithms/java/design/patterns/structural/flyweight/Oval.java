package com.data.structures.algorithms.java.design.patterns.structural.flyweight;

import java.awt.*;

public class Oval implements JShape {
    boolean fill;
    public Oval(boolean fillColor) {
        System.out.println("Creating oval with fill " + fillColor);
        fill = fillColor;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics oval, int x, int y, int width, int height, Color color) {
        oval.setColor(color);
        oval.drawOval(x, y, width, height);
        if(this.fill) {
            oval.fillOval(x, y, width, height);
        }
    }
}
