package com.data.structures.algorithms.java.design.patterns.behavioral.interpreter;


public class Interpreter {

    private final Context context;

    public Interpreter(Context context) {
        this.context = context;
    }

    public int interpret(String expression) {
        Expression expressionTree = buildExpressionTree(expression);
        return expressionTree.interpret(this.context);
    }

    public Expression buildExpressionTree(String expression) {
        return new AdditionExpression(
                new NumberExpression(2),
                new MultiplicationExpression(new NumberExpression(3), new NumberExpression(4))
        );
    }
}
