package com.data.structures.algorithms.java.design.patterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> cartItems;

    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.cartItems.add(item);
    }

    public void removeItem(Item item) {
        this.cartItems.remove(item);
    }

    public int calculateTotal() {
        int total = 0;
        for (Item item: cartItems) {
            total += item.price();
        }
        return total;
    }

    public void pay(PaymentProvider paymentProvider) {
        int totalAmount = this.calculateTotal();
        paymentProvider.pay(totalAmount);
    }
}
