package com.data.structures.algorithms.java.design.patterns.structural.flyweight;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    private static final Map<ShapeType, JShape> shapeTypes = new HashMap<>();

    public static JShape getShape(ShapeType shapeType) {
        JShape shapeImpl = shapeTypes.get(shapeType);

        if (shapeImpl == null) {
            switch (shapeType) {
                case OVAL_FILL:
                    shapeImpl = new Oval(true);
                    shapeTypes.put(shapeType, shapeImpl);
                    break;
                case OVAL_NO_FILL:
                    shapeImpl = new Oval(false);
                    shapeTypes.put(shapeType, shapeImpl);
                    break;
                case LINE:
                    shapeImpl = new Line();
                    shapeTypes.put(shapeType, shapeImpl);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown shape type");

            }
        }
        return shapeImpl;
    }

    public enum ShapeType {
        OVAL_FILL,
        OVAL_NO_FILL,
        LINE
    }

}
