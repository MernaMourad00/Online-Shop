package org.example.entities;

public class Customer extends User {

    int CustomerId;
    private int SSN;
    private int creditCardNumber;

    public Customer(String name, String email, int customerId, int SSN, int creditCardNumber) {
        super(name, email);
        CustomerId = customerId;
        this.SSN = SSN;
        this.creditCardNumber = creditCardNumber;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }


}
