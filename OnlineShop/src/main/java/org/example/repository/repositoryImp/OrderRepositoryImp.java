package org.example.repository.repositoryImp;

import org.example.DbConnection;
import org.example.entities.Category;
import org.example.entities.Customer;
import org.example.entities.Order;
import org.example.repository.IOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImp implements IOrder {
    @Override
    public void addOrder(Order order) throws SQLException {


        Connection conn = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO orders(customer_id," +
                " total_price,order_status," +
                "order_date) " +
                "VALUES (?,?,?,?);";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, order.getCustomer().getCustomerId());
        ps.setDouble(2, order.getTotalPrice());
        ps.setString(3, order.getOrderStatus());
        ps.setDate(4, order.getOrderDate());

        ps.executeUpdate();
        System.out.println("done");
    }

    @Override
    public List<Order> getAllOrders() throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        List<Order> orders = new ArrayList<>();
        Statement stmt= null;
        int customerId=0;
        double price=0;
        String status=null;
        Date date;
        stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select *  from orders;");
        while(resultSet.next()){
            customerId = resultSet.getInt(2);
            price = resultSet.getDouble(3);
            status = resultSet.getString(4);
            date = resultSet.getDate(5);
            CustomerRepositoryImp imp = new CustomerRepositoryImp();
            Customer customer = imp.getCustomerById(customerId);
            Order order = new Order(customer,price,status,date);
            orders.add(order);
        }
        return orders;
    }
//"SELECT * FROM customer WHERE customer_id = " + customerId
    @Override
    public List<Order> getAllOrdersOfaCustomer(int customerId) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        List<Order> orders = new ArrayList<>();
        Statement stmt= null;
        CustomerRepositoryImp imp = new CustomerRepositoryImp();
        Customer customer = imp.getCustomerById(customerId);
        double price=0;
        String status=null;
        Date date;

        stmt = conn.createStatement();

        ResultSet resultSet = stmt.executeQuery("SELECT * FROM orders WHERE customer_id = " + customerId);

        while(resultSet.next()){
            price = resultSet.getDouble(3);
            status = resultSet.getString(4);
            date = resultSet.getDate(5);

            Order order = new Order(customer,price,status,date);
            orders.add(order);

        }
        return orders;
    }
//SELECT * FROM orders WHERE order_date >= ? AND order_date <= ?
    @Override
    public List<Order> getOrdersWithinCertainPeriod(Date startDate, Date endDate) throws SQLException {

        Connection conn = DbConnection.getInstance().getConnection();

        List<Order> orders = new ArrayList<>();
        int customerId=0;
        double price=0;
        String status=null;
        Date date;

        String sql="SELECT * FROM orders WHERE order_date >= ? AND order_date <= ?; ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDate(1, startDate);
        pstmt.setDate(2, endDate);

        ResultSet resultSet = pstmt.executeQuery();
        while(resultSet.next()){
            customerId = resultSet.getInt(2);
            price = resultSet.getDouble(3);
            status = resultSet.getString(4);
            date = resultSet.getDate(5);
            CustomerRepositoryImp imp = new CustomerRepositoryImp();
            Customer customer = imp.getCustomerById(customerId);
            Order order = new Order(customer,price,status,date);
            orders.add(order);
        }
        return orders;
    }

    @Override
    public void CancelOrder(int orderId) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        String query = "UPDATE orders SET order_status = ? WHERE order_id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, "cancelled");
        preparedStatement.setInt(2, orderId);
        preparedStatement.executeUpdate();
        System.out.println("order cancelled");
    }

    @Override
    public Order getOrderById(int orderId) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        Statement stmt= null;
        Order order;
        stmt = conn.createStatement();
        int customerId=0;
        double total=0.0;
        String orderStatus="";
        Date date=null;


        ResultSet resultSet = stmt.executeQuery("select * from orders WHERE order_id ="+ orderId);

        while(resultSet.next()){

            customerId = resultSet.getInt(2);
            total = resultSet.getDouble(3);
            orderStatus = resultSet.getString(4);
            date = resultSet.getDate(5);
        }

       Customer customer = new CustomerRepositoryImp().getCustomerById(customerId);
        order = new Order(orderId,customer,total,orderStatus,date);


        return order;
    }
}
