package com.data.structures.algorithms.java.design.patterns;

import com.data.structures.algorithms.java.design.patterns.creational.abstractfactory.WindowsFactory;
import com.data.structures.algorithms.java.design.patterns.creational.builder.BuilderPattern;
import com.data.structures.algorithms.java.design.patterns.creational.factory.Gui;
import com.data.structures.algorithms.java.design.patterns.creational.factory.GuiEnum;
import com.data.structures.algorithms.java.design.patterns.creational.factory.GuiFactory;
import com.data.structures.algorithms.java.design.patterns.creational.prototype.PrototypePattern;
import com.data.structures.algorithms.java.design.patterns.creational.singleton.EagerInitialization;
import com.data.structures.algorithms.java.design.patterns.creational.singleton.EnumSingleton;
import com.data.structures.algorithms.java.design.patterns.creational.singleton.LazyInitialization;
import com.data.structures.algorithms.java.design.patterns.structural.adapter.SocketAdapter;
import com.data.structures.algorithms.java.design.patterns.structural.adapter.SocketClassAdapterImpl;
import com.data.structures.algorithms.java.design.patterns.structural.adapter.SocketObjectAdapterImpl;
import com.data.structures.algorithms.java.design.patterns.structural.adapter.Volt;
import com.data.structures.algorithms.java.design.patterns.structural.composite.Circle;
import com.data.structures.algorithms.java.design.patterns.structural.composite.Drawing;
import com.data.structures.algorithms.java.design.patterns.structural.composite.Shape;
import com.data.structures.algorithms.java.design.patterns.structural.composite.Triangle;
import com.data.structures.algorithms.java.design.patterns.structural.proxy.CommandExecutor;
import com.data.structures.algorithms.java.design.patterns.structural.proxy.CommandProxyExecutor;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Creational

        // Singleton
        EnumSingleton singleton = EnumSingleton.INSTANCE;

        EagerInitialization.getInstance();
        LazyInitialization.getInstanceDoubleLocking();

        // Factory
        Gui mac = GuiFactory.getInstance(GuiEnum.MAC);
        // Abstract factory
        com.data.structures.algorithms.java.design.patterns.creational.abstractfactory.Gui windows = com.data.structures.algorithms.java.design.patterns.creational.abstractfactory.GuiFactory.getGui(new WindowsFactory());

        // builder
        BuilderPattern builder = BuilderPattern.getBuilder()
                .setValue1(1)
                .setValue2(2)
                .build();

        // Prototype
        PrototypePattern prototypePattern = new PrototypePattern();
        PrototypePattern prototypePattern1 = prototypePattern.clone();

        // -----------------------------------------------------------------------------------------------------------
        // Structural

        // Adapter
        SocketAdapter classSocketAdapter = new SocketClassAdapterImpl();
        Volt classVolt120 = classSocketAdapter.get120Volt();
        Volt classVolt12 = classSocketAdapter.get12Volt();
        Volt classVolt3 = classSocketAdapter.get3Volt();

        SocketAdapter objectSocketAdapter = new SocketObjectAdapterImpl();
        Volt objVolt120 = objectSocketAdapter.get120Volt();
        Volt objVolt12 = objectSocketAdapter.get12Volt();
        Volt objVolt3 = objectSocketAdapter.get3Volt();

        print(classVolt120.getVolt()); print(classVolt12.getVolt()); print(classVolt3.getVolt());
        print(objVolt120.getVolt()); print(objVolt12.getVolt()); print(objVolt3.getVolt());

        // Composite
        Shape tri = new Triangle();
        Shape cir = new Circle();

        Drawing drawing = new Drawing();

        drawing.add(tri);
        drawing.add(cir);
        drawing.draw("Red");
        drawing.draw("green");
        drawing.clear();

        // Proxy

        CommandExecutor commandExecutor = new CommandProxyExecutor("Shanmuga", "wrong_z`pwd");
        commandExecutor.runCommand("rm abc.pdf");

    }

    private static void print(Object obj) {
        System.out.println(obj);
    }
}
