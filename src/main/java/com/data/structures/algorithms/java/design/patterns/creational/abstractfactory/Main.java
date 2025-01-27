package com.data.structures.algorithms.java.design.patterns.creational.abstractfactory;

public class Main {

    public static void main(String[] args) {
        Gui mac = GuiFactory.getGui(new MacFactory());
    }
}
