package org.example;

import org.example.entities.*;
import org.example.repository.repositoryImp.CategoryRepositoryImp;
import org.example.repository.repositoryImp.ProductRepositoryImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

 //--------------------------------------category----------------------------------------
        //CategoryRepositoryImp categoryRepositoryImp = new CategoryRepositoryImp();
//       Category category1 = new Category("clothes","BLABLABALBALABA");
//        Category category2 = new Category("toys","aaaaaaaaaa");
//        Category category3 = new Category("electronics","bbbbbbbbbbb");
//        categoryRepositoryImp.addCategory(category1.getName(), category1.getDescription());
//        categoryRepositoryImp.addCategory(category2.getName(), category2.getDescription());
//        categoryRepositoryImp.addCategory(category3.getName(), category3.getDescription());
      //  List<Category>categories = categoryRepositoryImp.getAllCategories();
//
//        categoryRepositoryImp.deleteCategory(2);
//            categoryRepositoryImp.editCategoryDescription(7,"edited category description");

//--------------------------------------product----------------------------------------//
//        ProductRepositoryImp productRepositoryImp = new ProductRepositoryImp();
//
//        Product product= productRepositoryImp.getProductById(2);
//
//        System.out.println(product.getName());
//        productRepositoryImp.getAllProducts();


        Product builder = new ProductBuilder("ball",150)
                .category(8)
                .description("a bouncy ball")
                .imageURL("aaaaa")
                .build();

        
        CashOnDelivery cashOnDelivery = new CashOnDelivery();





//        productRepositoryImp.addProduct(builder);
//
//        productRepositoryImp.getByCategory(8);
//        productRepositoryImp.addSale(2,0.5);
//        System.out.println(productRepositoryImp.checkProductInStock(3));

        Connection conn = DbConnection.getInstance().getConnection();

        Director d = new Director(new CreditCard());


        int userId=1;
        UserSession instance = UserSession.getInstance();
        instance.loginUser(userId);

        instance.getUserId();




    }
}