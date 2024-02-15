package org.example.entities;

public class Director {

    PaymentStrategy paymentStrategy;

    public Director(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void PerformPayment(int amount){

        this.paymentStrategy.Pay();

    }


}
