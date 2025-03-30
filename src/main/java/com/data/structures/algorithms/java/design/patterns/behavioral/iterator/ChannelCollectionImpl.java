package com.data.structures.algorithms.java.design.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class ChannelCollectionImpl implements ChannelCollection {
    private List<Channel> channelList;
    public ChannelCollectionImpl() {
        channelList = new ArrayList<>();
    }
    @Override
    public void addChannel(Channel channel) {
        this.channelList.add(channel);
    }

    @Override
    public void removeChannel(Channel channel) {
        this.channelList.remove(channel);
    }

    @Override
    public ChannelIterator iterator(ChannelType type) {
        return new ChannelIteratorImpl(type, this.channelList);
    }

    private static class ChannelIteratorImpl implements ChannelIterator {
        private final ChannelType type;
        private final List<Channel> channelList;
        private int position;

        ChannelIteratorImpl(ChannelType type, List<Channel> channelList) {
            this.type = type;
            this.channelList = channelList;
        }

        @Override
        public boolean hasNext() {
            while (position < channelList.size()) {
                Channel channel = this.channelList.get(position);
                if (channel.type() == this.type || channel.type() == ChannelType.ALL) {
                    return true;
                } else position++;
            }
            return false;
        }

        @Override
        public Channel next() {
            Channel channel = this.channelList.get(position);
            position++;
            return channel;
        }
    }
}
