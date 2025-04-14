package com.data.structures.algorithms.java.design.patterns.behavioral.chainofresponsibility;

public class FiftyDollarDispenser implements DispenserChain{
    private DispenserChain chain;

    public void setNextChain(DispenserChain dispenserChain) {
        this.chain = dispenserChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.amount() >= 50) {
            int count = currency.amount() / 50;
            System.out.println("Dispensing " + count + " 50$ notes");
            int remaining = currency.amount() % 50;
            if (remaining > 0) this.chain.dispense(new Currency(remaining));
        } else {
            this.chain.dispense(currency);
        }
    }
}
