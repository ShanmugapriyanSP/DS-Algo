package com.data.structures.algorithms.java.design.patterns.behavioral.state;

public class TVContext {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void doAction() {
        this.state.doAction();
    }
}
