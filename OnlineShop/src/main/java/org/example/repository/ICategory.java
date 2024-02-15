package org.example.repository;

import org.example.entities.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategory {
     void addCategory(String categoryName,String categoryDescription) throws SQLException;
     void deleteCategory(int categoryID) throws SQLException;
     void editCategoryDescription(int category_id,String categoryDescription) throws SQLException;
     List<Category> getAllCategories() throws SQLException;

}
