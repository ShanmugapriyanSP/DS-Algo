package com.data.structures.algorithms.java.design.patterns.behavioral.memento;

import org.w3c.dom.Text;

import java.util.Stack;

public class CareTaker {

    private Stack<Memento> history;

    public CareTaker() {
        this.history = new Stack<>();
    }

    public void saveState(TextEditor textEditor) {
        history.push(textEditor.save());
    }
    public void undo(TextEditor textEditor) {

        if (history.isEmpty()) {
            System.out.println("No history found");
            return;
        }
        textEditor.restore(history.pop());
    }
}
