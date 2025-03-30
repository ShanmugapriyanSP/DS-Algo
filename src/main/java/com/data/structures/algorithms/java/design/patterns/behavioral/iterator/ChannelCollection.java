package com.data.structures.algorithms.java.design.patterns.behavioral.iterator;

public interface ChannelCollection {

    public void addChannel(Channel channel);

    public void removeChannel(Channel channel);

    public ChannelIterator iterator(ChannelType type);
}
