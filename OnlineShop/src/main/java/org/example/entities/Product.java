package org.example.entities;

public class Product {

    private int productId;
    private String name;
    private double price;
    private String description;
    private int stockQuantity;
    private boolean onSale;
    private double salePercentage;
    private int category;
    private String imageURL;

    private ProductBuilder productBuilder;

    public Product(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }

//    private Product(int productId, String name, double price, String description, int stockQuantity,
//                   boolean onSale, double salePercentage,
//                   int category, String imageURL) {
//        this.productId = productId;
//        this.name = name;
//        this.price = price;
//        this.description = description;
//        this.stockQuantity = stockQuantity;
//        this.onSale = onSale;
//        this.salePercentage = salePercentage;
//        this.category = category;
//        this.imageURL = imageURL;
//    }


//    static Product createProduct(ProductBuilder builder) {
//        return new Product(builder.getProductId(), builder.getName(), builder.getPrice(),
//                builder.getDescription(),
//                builder.getStockQuantity(),builder.isOnSale(),builder.getSalePercentage(),
//                builder.getCategory(),builder.getImageURL());
//
//    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public double getSalePercentage() {
        return salePercentage;
    }

    public int getCategory() {
        return category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getProductId() {
        return productId;
    }
}
