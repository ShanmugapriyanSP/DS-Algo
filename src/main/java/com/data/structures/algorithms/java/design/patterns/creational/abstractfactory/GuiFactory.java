package com.data.structures.algorithms.java.design.patterns.creational.abstractfactory;

public class GuiFactory {

    public static Gui getGui(GuiAbstractFactory guiAbstractFactory) {
        return guiAbstractFactory.getGui();
    }
}
