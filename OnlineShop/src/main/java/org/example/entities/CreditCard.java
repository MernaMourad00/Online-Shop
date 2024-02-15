package org.example.entities;

public class CreditCard implements PaymentStrategy {
    @Override
    public String Pay() {
        return "Paid by Credit card";
    }
}
