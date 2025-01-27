package com.data.structures.algorithms.java.design.patterns.creational.factory;

public class GuiFactory {

    public static Gui getInstance(GuiEnum guiEnum) {

        switch (guiEnum) {
            case MAC:
                return new Mac();

            case WINDOWS:
                return new Windows();

            default:
                throw new IllegalArgumentException("Unknown GUI!!");

        }
    }
}
