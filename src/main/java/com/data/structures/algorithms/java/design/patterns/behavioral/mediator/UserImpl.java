package com.data.structures.algorithms.java.design.patterns.behavioral.mediator;

public class UserImpl extends User {

    public UserImpl(ChatMediator chatMediator, String username) {
        super(chatMediator, username);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(this.username + ": Sending message: " + message);
        chatMediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(this.username + ": Received message: " + message);
    }

}
