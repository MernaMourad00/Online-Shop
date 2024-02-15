package org.example.entities;

public class CashOnDelivery implements PaymentStrategy{
    @Override
    public String Pay() {
        return "Your payment method is cash on delivery";
    }
}
