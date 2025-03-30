package com.data.structures.algorithms.java.design.patterns.behavioral.memento;

public class TextEditor {

    private String content;

    public void write(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public Memento save() {
        return new Memento(this.content);
    }

    public void restore(Memento memento) {
        this.content = memento.state();
    }
}
