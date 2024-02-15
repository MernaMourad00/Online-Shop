package org.example.repository.repositoryImp;

import org.example.DbConnection;
import org.example.entities.Customer;
import org.example.entities.Feedback;
import org.example.repository.IFeedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackRepositoryImp implements IFeedback {
    @Override
    public void addFeedback(int product_id, int customer_id, int rating, String comment, Date dateCreated) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        String query = "INSERT INTO feedback(product_id, customer_id,rating,comment,data_created) VALUES (?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, product_id);
        ps.setInt(2, customer_id);
        ps.setInt(3, rating);
        ps.setString(4, comment);
        ps.setDate(5, dateCreated);
        ps.executeUpdate();
        System.out.println("done");
    }

    @Override
    public List<Feedback> getFeedbacks(int product_id) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        Statement stmt = null;
        Feedback feedback=null;
        List<Feedback> feedbacks = new ArrayList<>();
        stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM feedback WHERE product_id = " + product_id);

        while (resultSet.next()) {
            int rating = resultSet.getInt("rating");
            String comment = resultSet.getString("comment");
            Date dateCreated = resultSet.getDate("date_created");
            int customerId = resultSet.getInt("customer_id");

            CustomerRepositoryImp customerRepository = new CustomerRepositoryImp();
            Customer customer = customerRepository.getCustomerById(customerId);

            feedback = new Feedback(customer,rating,comment,dateCreated);
            feedbacks.add(feedback);


        }
        return feedbacks;
    }
}
