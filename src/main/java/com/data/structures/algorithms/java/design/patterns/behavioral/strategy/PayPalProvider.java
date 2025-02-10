package com.data.structures.algorithms.java.design.patterns.behavioral.strategy;

public class PayPalProvider implements PaymentProvider {

    private String emailId;
    private String password;

    public PayPalProvider(String email, String password) {
        this.emailId = email;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + "$ with PayPal account");
    }
}
