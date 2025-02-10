package com.data.structures.algorithms.java.design.patterns.behavioral.command;

public class WindowsFileSystemReceiver implements FileSystemReceiver {

    @Override
    public void open() {
        System.out.println("Opening file in Windows System");
    }

    @Override
    public void close() {
        System.out.println("Closing file in Windows System");
    }

    @Override
    public void write() {
        System.out.println("Writing file in Windows System");
    }
}
