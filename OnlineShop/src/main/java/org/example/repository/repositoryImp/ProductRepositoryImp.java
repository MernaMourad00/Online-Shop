package org.example.repository.repositoryImp;

import org.example.DbConnection;
import org.example.entities.Category;
import org.example.entities.Customer;
import org.example.entities.Product;
import org.example.entities.ProductBuilder;
import org.example.repository.IProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImp implements IProduct {
    @Override
    public void addProduct(Product product) throws SQLException {

        Connection conn = DbConnection.getInstance().getConnection();

        String query = "INSERT INTO product(product_name," +
                        " price,product_description," +
                        "stock_quantity,on_sale," +
                        "sale_percentage,category_id,image_url) " +
                        "VALUES (?,?,?,?,?,?,?,?);";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setString(3, product.getDescription());
        ps.setInt(4, product.getStockQuantity());
        ps.setBoolean(5, product.isOnSale());
        ps.setDouble(6, product.getSalePercentage());
        ps.setDouble(7, product.getCategory());
        ps.setString(8, product.getImageURL());

        ps.executeUpdate();
        System.out.println("done");

    }

    @Override
    public int checkProductInStock(int productId) throws SQLException {

        int quantity = -1;

        Connection conn = DbConnection.getInstance().getConnection();
        String query = "SELECT stock_quantity FROM product WHERE product_id = ?;";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, productId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            quantity = rs.getInt("stock_quantity");
        }

        return quantity;

    }

    @Override
    public void addSale(int productId,double salePercentage) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();

        String query = "UPDATE product SET on_sale = ?, sale_percentage = ? WHERE product_id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setBoolean(1, true); // Set the 'on_sale' field to true
        preparedStatement.setDouble(2, salePercentage); // Set the 'sale_percentage' field
        preparedStatement.setInt(3, productId); // Set the productId for the WHERE clause

        preparedStatement.executeUpdate();

    }

    @Override
    public List<Product> getByCategory(int categoryId) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        List<Product> products = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product WHERE category_id = ?;");
            stmt.setInt(1, categoryId);
            ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            int productId = resultSet.getInt("product_id");
            String name = resultSet.getString("product_name");
            String description = resultSet.getString("product_description");
            double price = resultSet.getDouble("price");
            String imageURL = resultSet.getString("image_url");
            boolean onSale = resultSet.getBoolean("on_sale");
            double salePercentage = resultSet.getDouble("sale_percentage");

            // Create Product objects and add them to the list
            Product product = new ProductBuilder(name, price)
                    .productId(productId)
                    .description(description)
                    .stockQuantity(resultSet.getInt("stock_quantity"))
                    .onSale(onSale)
                    .salePercentage(salePercentage)
                    .imageURL(imageURL)
                    .category(categoryId)
                    .build();

            products.add(product);
        }
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Image URL: " + product.getImageURL());
            System.out.println("On Sale: " + product.isOnSale());
            System.out.println("Sale Percentage: " + product.getSalePercentage());
            System.out.println("-----------------------------------");
        }
        return products;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        List<Product> products = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product;");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            int productId = resultSet.getInt("product_id");
            int categoryId = resultSet.getInt("category_id");
            String name = resultSet.getString("product_name");
            String description = resultSet.getString("product_description");
            double price = resultSet.getDouble("price");
            String imageURL = resultSet.getString("image_url");
            boolean onSale = resultSet.getBoolean("on_sale");
            double salePercentage = resultSet.getDouble("sale_percentage");

            // Create Product objects and add them to the list
            Product product = new ProductBuilder(name, price)
                    .productId(productId)
                    .description(description)
                    .stockQuantity(resultSet.getInt("stock_quantity"))
                    .onSale(onSale)
                    .salePercentage(salePercentage)
                    .imageURL(imageURL)
                    .category(categoryId)
                    .build();

            products.add(product);
        }
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Image URL: " + product.getImageURL());
            System.out.println("On Sale: " + product.isOnSale());
            System.out.println("Sale Percentage: " + product.getSalePercentage());
            System.out.println("-----------------------------------");
        }
        return products;

    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        Statement stmt = null;
        Product product= null;
        stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM product WHERE product_id = " + productId);

        while (resultSet.next()) {
            int categoryId = resultSet.getInt("category_id");
            String name = resultSet.getString("product_name");
            String description = resultSet.getString("product_description");
            double price = resultSet.getDouble("price");
            String imageURL = resultSet.getString("image_url");
            boolean onSale = resultSet.getBoolean("on_sale");
            double salePercentage = resultSet.getDouble("sale_percentage");
            int stockQuantity =  resultSet.getInt("stock_quantity");

            // Create Product objects and add them to the list
            product = new ProductBuilder(name, price)
                    .productId(productId)
                    .description(description)
                    .stockQuantity(stockQuantity)
                    .onSale(onSale)
                    .salePercentage(salePercentage)
                    .imageURL(imageURL)
                    .category(categoryId)
                    .build();

        }
        return product;
    }
}
