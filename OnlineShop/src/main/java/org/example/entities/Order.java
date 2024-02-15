package org.example.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Order {

    private int orderId;
    private Customer customer;
    private double totalPrice;
    private String orderStatus;
    private Date orderDate;

    public Order(Customer customer, double totalPrice, String orderStatus, Date orderDate) {
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public Order(int orderId, Customer customer, double totalPrice, String orderStatus, Date orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
