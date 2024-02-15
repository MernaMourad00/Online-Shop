package org.example.repository;

import org.example.entities.Order;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface IOrder {
         void addOrder(Order order) throws SQLException; // user
         List<Order> getAllOrders() throws SQLException; // admin
         List<Order> getAllOrdersOfaCustomer(int customerId) throws SQLException; // user
         List<Order> getOrdersWithinCertainPeriod(Date startDate, Date endDate) throws SQLException; // admin
         void CancelOrder(int orderId) throws SQLException; // user
         Order getOrderById(int orderId) throws SQLException;

}
