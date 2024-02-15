package org.example.repository.repositoryImp;

import org.example.DbConnection;
import org.example.entities.Category;
import org.example.repository.ICategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImp implements ICategory {



    @Override
    public void addCategory(String categoryName,String categoryDescription) throws SQLException {

            Connection conn = DbConnection.getInstance().getConnection();
            String query = "INSERT INTO category(category_name, category_description) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, categoryName);
            ps.setString(2, categoryDescription);
            ps.executeUpdate();
            System.out.println("done");


    }

    @Override
    public void deleteCategory(int categoryID) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
            String query = "DELETE FROM category WHERE category_id = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, categoryID);
            ps.executeUpdate();
            System.out.println("done");

    }

    @Override
    public void editCategoryDescription(int category_id,String categoryDescription) throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();

        String query = "UPDATE category SET category_description = ? WHERE category_id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, categoryDescription);
        preparedStatement.setInt(2, category_id);

            preparedStatement.executeUpdate();

    }
    @Override
    public List<Category> getAllCategories() throws SQLException {
        Connection conn = DbConnection.getInstance().getConnection();
        List<Category> categories = new ArrayList<>();
        Statement stmt= null;
        int categoryId;
        String categoryName;
        String categoryDescription;


            stmt = conn.createStatement();

        ResultSet resultSet = stmt.executeQuery("select *  from category;");

        while(resultSet.next()){
            categoryId = resultSet.getInt(1);
            categoryName = resultSet.getString(2);
            categoryDescription = resultSet.getString(3);

            Category category = new Category(categoryId,categoryName,categoryDescription);
            categories.add(category);

        }

            for (Category category : categories) {
                System.out.println("Category ID: " + category.getCategoryId());
                System.out.println("Category Name: " + category.getName());
                System.out.println("Category Description: " + category.getDescription());
                System.out.println("--------------------------------------");
            }
        return categories;

    }
}
