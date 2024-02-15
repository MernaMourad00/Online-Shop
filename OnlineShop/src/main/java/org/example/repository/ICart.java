package org.example.repository;

import org.example.entities.City;
import java.sql.SQLException;
import java.util.List;

public interface ICart {

     void createCartForCustomer(int customerId) throws SQLException;
     void addItemToCart(int cartId, int productId, int quantity) throws SQLException;
     void deleteItemFromCart(int cartItemId) throws SQLException;
     List<City> getAllCities() throws SQLException;
     int getCartId(int CustomerId) throws SQLException;


}
