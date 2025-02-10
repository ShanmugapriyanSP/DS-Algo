package com.data.structures.algorithms.java.design.patterns.behavioral.chainofresponsibility;

public class TenDollarDispenser implements DispenserChain{
    private DispenserChain chain;

    public void setNextChain(DispenserChain dispenserChain) {
        this.chain = dispenserChain;
    }
    @Override
    public void dispense(Currency currency) {
        if (currency.amount() >= 10) {
            int count = currency.amount() / 10;
            System.out.println("Dispensing " + count + " 10$ notes");
            int remaining = currency.amount() % 10;
            if (remaining > 0) this.chain.dispense(new Currency(remaining));
        } else {
            this.chain.dispense(currency);
        }
    }
}
