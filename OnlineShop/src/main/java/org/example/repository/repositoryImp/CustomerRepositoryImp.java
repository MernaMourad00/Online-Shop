package org.example.repository.repositoryImp;

import org.example.DbConnection;
import org.example.entities.Category;
import org.example.entities.Customer;
import org.example.repository.ICustomer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImp implements ICustomer {


    DbConnection isntance = DbConnection.getInstance();
    Connection opendconn = isntance.getConnection();

    @Override
    public List<Customer> getAllCustomers() throws SQLException {

        List<Customer> customers = new ArrayList<>();
        Connection conn = opendconn;
        Statement stmt= null;
        int customerId;
        String customerName;
        String email;
        int SSN;
        int creditCardInfo;

            stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery("select *  from customer;");

            while(resultSet.next()){
                customerId = resultSet.getInt(1);
                customerName = resultSet.getString(2);
                email = resultSet.getString(3);
                SSN = resultSet.getInt(5);
                creditCardInfo = resultSet.getInt(6);

               Customer customer = new Customer(customerName,email,customerId,SSN,creditCardInfo);
               customers.add(customer);

            }
            for (Customer customer : customers) {
                System.out.println("customer ID: " + customer.getCustomerId());
                System.out.println("customer Name: " + customer.getName());
                System.out.println("customer email: " + customer.getEmail());
                System.out.println("customer SSN: " + customer.getSSN());
                System.out.println("customer creditcard: " + customer.getCreditCardNumber());
                System.out.println("--------------------------------------");
            }
        return customers;

    }

    @Override
    public int login(String email, String password) throws SQLException {
        int customerId = -1;

        Connection conn = DbConnection.getInstance().getConnection();
            String query = "SELECT customer_id FROM customer WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customerId = rs.getInt("customer_id"); // Set the customer ID if credentials match
            }

        return customerId;
    }


    @Override
    public void signup(Customer customer) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        String query = "INSERT INTO customer(name,email,password,ssn,credit_card_number) VALUES (?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getEmail());
        ps.setString(3, customer.getPassword());
        ps.setInt(2, customer.getSSN());
        ps.setInt(2, customer.getCreditCardNumber());
        ps.executeUpdate();
        System.out.println("done");
    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        String query = "DELETE FROM customer WHERE customer_id = ?;";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,customerId );
        ps.executeUpdate();
        System.out.println("done");

    }

    @Override
    public void editPassword(int customerId, String password) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();

        String query = "UPDATE customer SET password = ? WHERE customer_id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, password);
        preparedStatement.setInt(2, customerId);

        preparedStatement.executeUpdate();
    }

    @Override
    public void editUsername(int customerId, String name) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        String query = "UPDATE customer SET name = ? WHERE customer_id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, customerId);
        preparedStatement.executeUpdate();


    }

    @Override
    public void editCreditCardInfo(int customerId, int creditCard) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        String query = "UPDATE customer SET credit_card_number = ? WHERE customer_id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, creditCard);
        preparedStatement.setInt(2, customerId);
        preparedStatement.executeUpdate();

    }

    @Override
    public Customer getCustomerById(int customerId) throws SQLException {
        Connection conn = opendconn;
        Statement stmt = null;
        Customer customer = null;
        stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM customer WHERE customer_id = " + customerId);

        while (resultSet.next()) {
            String customerName = resultSet.getString("customer_name");
            String email = resultSet.getString("email");
            int SSN = resultSet.getInt("SSN");
            int creditCardInfo = resultSet.getInt("credit_card_info");

            customer = new Customer(customerName, email, customerId, SSN, creditCardInfo);

        }
        return customer;
    }
}
