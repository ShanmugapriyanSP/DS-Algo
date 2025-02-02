package com.data.structures.algorithms.java.design.patterns.structural.decorator;

public class SubtitledStream extends VideoStreamDecorator{

    private String language;

    public SubtitledStream(VideoStream videoStream, String language) {
        super(videoStream);
        this.language = language;
    }

    public void play() {
        super.play();
        System.out.println("Adding " + language + " subtitle");
    }
}
