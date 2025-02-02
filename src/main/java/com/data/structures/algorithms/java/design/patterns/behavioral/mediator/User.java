package com.data.structures.algorithms.java.design.patterns.behavioral.mediator;

public abstract class User {

    protected ChatMediator chatMediator;
    protected String username;

    public User(ChatMediator chatMediator, String username) {
        this.chatMediator = chatMediator;
        this.username = username;
    }

    public abstract void sendMessage(String message);

    public abstract void receiveMessage(String message);
}
