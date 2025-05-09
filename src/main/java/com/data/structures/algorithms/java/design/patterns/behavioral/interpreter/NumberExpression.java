package com.data.structures.algorithms.java.design.patterns.behavioral.interpreter;

public class NumberExpression implements Expression {
    private int value;

    public NumberExpression(int value) {
        this.value = value;
    }

    @Override
    public int interpret(Context context) {
        return value;
    }
}
