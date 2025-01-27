package com.data.structures.algorithms.java.design.patterns.structural.proxy;

import java.io.IOException;

public class CommandProxyExecutor implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor commandExecutor;

    public CommandProxyExecutor(String user, String password) {
        if (user.equals("Shanmuga") && "pwd".equals(password)) {
            isAdmin = true;
        }
        commandExecutor = new CommandExecutorImpl();
    }

    public void runCommand(String command) throws IOException {
        if (isAdmin) {
            commandExecutor.runCommand(command);
        } else {
            if (command.startsWith("rm")) {
                System.out.println("You are not an admin to run this command");
            } else {
                commandExecutor.runCommand(command);
            }
        }
    }
}
