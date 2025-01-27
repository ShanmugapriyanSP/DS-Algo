package com.data.structures.algorithms.java.design.patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypePattern implements Cloneable{

    private Map<String, String> map;

    public PrototypePattern() {
        map = new HashMap<>();
    }
    
    public PrototypePattern(Map<String, String> map) {
        this.map = map;
    }

    private void loadValues() {
        map.put("Key1", "Value1");
        map.put("Key2", "Value2");
    }

    @Override
    public PrototypePattern clone() {
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<String, String> entrySet: this.map.entrySet()) {
            map.put(entrySet.getKey(), entrySet.getValue());
        }
        return new PrototypePattern(this.map);
    }
}
