package org.example.repository;

import org.example.entities.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomer {
     List<Customer> getAllCustomers() throws SQLException;
     int login(String email, String password) throws SQLException;
     void signup(Customer customer) throws SQLException;
     void deleteCustomer(int customerId) throws SQLException;
     void editPassword(int customerId,String password) throws SQLException;
     void editUsername(int customerId,String name) throws SQLException;
     void editCreditCardInfo(int customerId,int creditCard) throws SQLException;
     Customer getCustomerById(int customerId) throws SQLException;



}
