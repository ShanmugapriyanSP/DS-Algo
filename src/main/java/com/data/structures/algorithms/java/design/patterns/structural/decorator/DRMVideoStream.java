package com.data.structures.algorithms.java.design.patterns.structural.decorator;

public class DRMVideoStream extends VideoStreamDecorator{

    private String drm;

    public DRMVideoStream(VideoStream videoStream, String drmType) {
        super(videoStream);
        this.drm = drmType;
    }

    public void play() {
        super.play();
        System.out.println("Applying DRM - " + drm);
    }

}
