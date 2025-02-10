package com.data.structures.algorithms.java.design.patterns.behavioral.command;

public class WriteFileCommand implements Command{

    private FileSystemReceiver fileSystemReceiver;

    public WriteFileCommand(FileSystemReceiver fileSystemReceiver) {
        this.fileSystemReceiver = fileSystemReceiver;
    }

    @Override
    public void execute() {
        fileSystemReceiver.write();
    }
}
