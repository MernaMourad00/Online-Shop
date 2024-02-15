package org.example.repository;

import org.example.entities.Feedback;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public interface IFeedback {

     void addFeedback(int product_id, int customer_id, int rating,
                            String comment, Date dateCreated) throws SQLException;
     List<Feedback> getFeedbacks(int product_id) throws SQLException;

}
