package com.data.structures.algorithms.java.design.patterns.creational.factory;


public class FactoryPattern {

    public static void main(String[] args) {
        Gui mac = GuiFactory.getInstance(GuiEnum.MAC);
        Gui windows = GenericFactory.getInstance(Windows.class);
    }
}


