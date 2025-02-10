package com.data.structures.algorithms.java.design.patterns.behavioral.observer;


public class TopicSubscriber implements Observer{

    private String name;
    private Subject topic;
    public TopicSubscriber(String name) {
        this.name = name;
    }
    @Override
    public void update() {
        String message = this.topic.getUpdate();
        if (message == null) {
            System.out.println("No new messages...");
        } else {
            System.out.println("Consuming new message - " + message);
        }
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic = sub;
    }
}
