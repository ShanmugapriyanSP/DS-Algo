package com.data.structures.algorithms.java.design.patterns.structural.proxy;

import java.io.IOException;

public class CommandExecutorImpl implements CommandExecutor {

    public void runCommand(String command) throws IOException {
        Runtime.getRuntime().exec(command);
        System.out.println(command + "command executed..");
    }
}
