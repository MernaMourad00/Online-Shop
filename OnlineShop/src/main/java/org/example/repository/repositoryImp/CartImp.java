package org.example.repository.repositoryImp;

import org.example.DbConnection;
import org.example.entities.City;
import org.example.repository.ICart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartImp implements ICart {

    @Override
    public void createCartForCustomer(int customerId) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        String query = "INSERT INTO cart(customer_id) VALUES (?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, customerId);
        ps.executeUpdate();
        System.out.println("done");
    }


    @Override
    public void addItemToCart(int cartId, int productId, int quantity) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        String query = "INSERT INTO product_cart(cart_id,product_id,quantity) VALUES (?,?,?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, cartId);
        ps.setInt(2, productId);
        ps.setInt(3, quantity);
        ps.executeUpdate();
        System.out.println("done");
    }
//DELETE FROM CartItems WHERE cart_item_id = ?
    @Override
    public void deleteItemFromCart(int cartItemId) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        String query = "DELETE FROM product_cart WHERE product_cart_id = ?;";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, cartItemId);
        ps.executeUpdate();
        System.out.println("done");

    }

    @Override
    public List<City> getAllCities() throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        List<City> cities = new ArrayList<>();
        Statement stmt= null;
        int cityId;
        String cityName;
        String EDT;


        stmt = conn.createStatement();

        ResultSet resultSet = stmt.executeQuery("select *  from estimateddeliverytime;");

        while(resultSet.next()){
            cityId = resultSet.getInt(1);
            cityName = resultSet.getString(2);
            EDT = resultSet.getString(3);

            City city = new City(cityId,cityName,EDT);
            cities.add(city);
        }

        return cities;
    }

    @Override
    public int getCartId(int CustomerId) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        Statement stmt= null;
        int cartId=0;
        stmt = conn.createStatement();

        ResultSet resultSet = stmt.executeQuery("select *  from product_cart WHERE customer_id ="+ CustomerId);

        while(resultSet.next()){
            cartId = resultSet.getInt(1);
        }

        return cartId;
    }
}
