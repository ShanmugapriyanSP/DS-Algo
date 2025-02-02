package com.data.structures.algorithms.java.design.patterns.structural.decorator;

public class VideoStreamDecorator implements VideoStream{

    protected VideoStream videoStream;

    public VideoStreamDecorator(VideoStream videoStream) {
        this.videoStream = videoStream;
    }

    public void play() {
        videoStream.play();
    }
}
