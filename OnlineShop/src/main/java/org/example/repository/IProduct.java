package org.example.repository;

import org.example.entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
     void addProduct(Product product) throws SQLException; //admin shaghala
     int checkProductInStock(int productId) throws SQLException; //admin shaghala
     void addSale(int productId,double salePercentage) throws SQLException; //modify product - admin shaghala
     List<Product> getByCategory(int categoryId) throws SQLException; // shaghala
     List<Product> getAllProducts() throws SQLException; //user shaghala
     Product getProductById(int productId) throws SQLException; // shaghala

}
