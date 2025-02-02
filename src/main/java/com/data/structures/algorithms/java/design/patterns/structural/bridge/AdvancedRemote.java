package com.data.structures.algorithms.java.design.patterns.structural.bridge;

public class AdvancedRemote extends Remote {

    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Muting the volume");
        this.device.setVolume(0);
    }
}
