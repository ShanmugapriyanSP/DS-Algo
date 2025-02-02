package com.data.structures.algorithms.java.design.patterns.structural.flyweight;

import javax.swing.*;

import com.data.structures.algorithms.java.design.patterns.structural.flyweight.ShapeFactory.ShapeType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DrawingClient extends JFrame {

    private final int width;
    private final int height;
    private final Random random;

    private static final ShapeType[] shapeTypes = {ShapeType.LINE, ShapeType.OVAL_FILL, ShapeType.OVAL_NO_FILL};
    private static final Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.BLACK};

    public DrawingClient(int width, int height) {
        this.width = width;
        this.height = height;
        this.random = new Random();

        Container contentPane = getContentPane();

        JButton startButton = new JButton("Draw");
        final JPanel panel = new JPanel();

        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);
        setSize(this.width, this.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Graphics g = panel.getGraphics();
                for (int i = 0; i < 100; ++i) {
                    JShape shape = ShapeFactory.getShape(getRandomShape());
                    shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(),
                            getRandomHeight(), getRandomColor());
                }
            }
        });

    }

    private ShapeType getRandomShape() {
        return shapeTypes[this.random.nextInt(shapeTypes.length)];
    }

    private int getRandomX() {
        return this.random.nextInt(width);
    }

    private int getRandomY() {
        return this.random.nextInt(height);
    }

    private int getRandomWidth() {
        return this.random.nextInt(width / 10);
    }

    private int getRandomHeight() {
        return this.random.nextInt(height / 10);
    }

    private Color getRandomColor() {
        return colors[this.random.nextInt(colors.length)];
    }
}
