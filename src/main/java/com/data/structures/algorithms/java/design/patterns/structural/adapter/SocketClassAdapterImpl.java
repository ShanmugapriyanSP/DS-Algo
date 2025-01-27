package com.data.structures.algorithms.java.design.patterns.structural.adapter;

public class SocketClassAdapterImpl extends Socket implements SocketAdapter{


    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(getVolt(), 10);
    }

    @Override
    public Volt get3Volt() {
        return convertVolt(getVolt(), 40);
    }

    private Volt convertVolt(Volt volt, int i) {
        return new Volt(volt.getVolt()/i);
    }
}
