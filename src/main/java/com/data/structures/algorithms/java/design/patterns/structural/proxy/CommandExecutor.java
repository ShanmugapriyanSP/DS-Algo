package com.data.structures.algorithms.java.design.patterns.structural.proxy;

import java.io.IOException;

public interface CommandExecutor {

    public void runCommand(String command) throws IOException;
}
