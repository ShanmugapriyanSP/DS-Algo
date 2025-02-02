package com.data.structures.algorithms.java.design.patterns.structural.facade;

public class HomeTheatreFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Amplifier amplifier;
    private Lights lights;

    public HomeTheatreFacade(DVDPlayer dvdPlayer, Projector projector, Amplifier amplifier, Lights lights) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.amplifier = amplifier;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("\n------Starting MOVIE----");
        lights.dim(30);
        projector.on();
        projector.setInput("DVD");
        amplifier.on();
        amplifier.setVolume(70);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("\n------Stopping MOVIE------");
        dvdPlayer.stop();
        dvdPlayer.off();
        amplifier.off();
        projector.off();
        lights.on();
    }
}
