package org.example.entities;


import java.sql.Date;

public class Feedback {
//    private Product product;
    public Customer customer;
    private int rating;
    private String comment;
    private Date date;

    public Feedback(Customer customer, int rating, String comment, Date date) {
        this.customer = customer;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }
}
