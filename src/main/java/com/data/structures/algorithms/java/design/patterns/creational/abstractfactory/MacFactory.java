package com.data.structures.algorithms.java.design.patterns.creational.abstractfactory;

public class MacFactory implements GuiAbstractFactory {

    @Override
    public Gui getGui() {
        return new Mac();
    }
}
