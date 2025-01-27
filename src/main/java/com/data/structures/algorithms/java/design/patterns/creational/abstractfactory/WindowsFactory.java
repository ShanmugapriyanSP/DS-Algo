package com.data.structures.algorithms.java.design.patterns.creational.abstractfactory;

public class WindowsFactory implements GuiAbstractFactory{


    @Override
    public Gui getGui() {
        return new Windows();
    }
}
