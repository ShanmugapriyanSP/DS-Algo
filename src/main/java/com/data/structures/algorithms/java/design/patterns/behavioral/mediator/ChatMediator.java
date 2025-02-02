package com.data.structures.algorithms.java.design.patterns.behavioral.mediator;

public interface ChatMediator {

    void addUser(User user);

    void removeUser(User user);

    void sendMessage(String message, User user);

}
