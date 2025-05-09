package com.data.structures.algorithms.java.design.patterns.behavioral.interpreter;

public class MultiplicationExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public MultiplicationExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}
