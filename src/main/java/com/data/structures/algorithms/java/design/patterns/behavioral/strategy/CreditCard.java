package com.data.structures.algorithms.java.design.patterns.behavioral.strategy;

public class CreditCard implements PaymentProvider {
    private String cardNumber;
    private String expiry;
    private String cvv;

    public CreditCard(String cardNumber, String expiry, String cvv) {
        this.cardNumber = cardNumber;
        this.expiry = expiry;
        this.cvv = cvv;
    }
    public void pay(int amount) {
        System.out.println("Paid " + amount + "$ with credit card");
    }
}
