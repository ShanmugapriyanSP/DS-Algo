package com.data.structures.algorithms.java.design.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Subject {

    private final Object MUTEX = new Object();
    private List<Observer> observers;
    private Boolean changed;
    private String message;

    public Topic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer == null) throw new NullPointerException("Empty observer...");
        synchronized (MUTEX) {
            if(!observers.contains(observer)) observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }



    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        synchronized (MUTEX) {
            if (Boolean.FALSE.equals(changed)) return;

            observersLocal = new ArrayList<>(observers);
            this.changed = false;
        }

        for (Observer o : observersLocal) {
            o.update();
        }
    }

    @Override
    public String getUpdate() {
        return this.message;
    }

    public void postMessage(String message) {
        this.message = message;
        this.changed = true;
        this.notifyObservers();
    }
}
