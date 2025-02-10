package com.data.structures.algorithms.java.design.patterns.behavioral.observer;

public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

    String getUpdate();
}
