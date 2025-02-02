package com.data.structures.algorithms.java.design.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {

    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }


    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void removeUser(User user) {
        this.users.remove(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for(User user: users) {
            if (user != sender) {
                user.receiveMessage(message);
            }
        }
    }
}
