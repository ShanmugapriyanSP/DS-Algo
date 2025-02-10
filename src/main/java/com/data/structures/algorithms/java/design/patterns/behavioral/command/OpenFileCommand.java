package com.data.structures.algorithms.java.design.patterns.behavioral.command;

import java.io.File;

public class OpenFileCommand implements Command{

    private FileSystemReceiver fileSystemReceiver;

    public OpenFileCommand(FileSystemReceiver fileSystemReceiver) {
        this.fileSystemReceiver = fileSystemReceiver;
    }

    @Override
    public void execute() {
        fileSystemReceiver.open();
    }
}
