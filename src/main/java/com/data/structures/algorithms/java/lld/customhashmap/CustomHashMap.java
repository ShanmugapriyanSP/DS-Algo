package com.data.structures.algorithms.java.lld.customhashmap;

public class CustomHashMap <K, V>{
    int capacity;
    Node<K, V>[] buckets;

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Node[capacity];
    }

    public void put(K key, V value) {
        Node<K, V> node = new Node<>(key, value, null);
        int index = getHashKey(key) % size();
        Node<K, V> current = buckets[index];
        if (current == null) {
            buckets[index] = node;
        } else {
            while (current.next != null) {
                if (current.getKey().equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            if (current.getKey().equals(key)) {
                current.value = value;
            } else {
                current.next = node;
            }
        }
    }

    public V get(K key) {
        int index = getHashKey(key);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = getHashKey(key) % size();
        Node<K, V> current = buckets[index];
        if (current == null)
            return null;

        Node<K, V> previous = null;
        while (current != null) {
            if (current.getKey().equals(key)) {
                if (previous == null) {
                    // Removing first node in bucket
                    buckets[index] = current.next;
                } else {
                    // Removing middle node
                    previous.next = current.next;
                }
                return current.value;
            }

            previous = current;
            current = current.next;
        }
        return null; // Key not found
    }

    public int size() {
        return this.buckets.length;
    }

    public int getHashKey(K key) {
        return key == null ? 0 : key.hashCode();
    }

}

class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;
    Node(K key, V value, Node<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    Node<K, V> getNext() {
        return next;
    }

}