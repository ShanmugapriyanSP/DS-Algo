package com.data.structures.algorithms.leetcode.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class QueueUsingStacks {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        List<String> inputs = Arrays.asList(
                "1 42",
                "2",
                "1 14",
                "3",
                "1 28",
                "3",
                "1 60",
                "1 78",
                "2",
                "2"
        );
        for (int i = 0; i < inputs.size(); i++) {
            String[] input = inputs.get(i).split(" ");
            int operation = Integer.valueOf(input[0]);

            switch (operation) {
                case 1:
                    int value = Integer.valueOf(input[1]);
                    myQueue.push(value);
                    break;
                case 2:
                    myQueue.pop();
                    break;
                case 3:
                    System.out.println(myQueue.peek());
                    break;
                default:
                    break;
            }
        }
        System.out.println(myQueue.peek());
    }
}

class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    private void fifo() {
        while(!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()) {
            fifo();
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()) {
            fifo();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return outStack.isEmpty();
    }
}