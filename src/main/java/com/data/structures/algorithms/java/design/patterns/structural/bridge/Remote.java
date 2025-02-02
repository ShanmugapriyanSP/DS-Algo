package com.data.structures.algorithms.java.design.patterns.structural.bridge;

public class Remote {

    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void on() {
        device.on();
    }

    public void off() {
        device.off();
    }

    public void setVolume(int volume) {
        device.setVolume(volume);
    }
}
