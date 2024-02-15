package org.example.entities;

public class ProductBuilder {

    private int productId;
    private String name;
    private double price;
    private String description="";
    private int stockQuantity=0;
    private boolean onSale=false;
    private double salePercentage=0;
    private int category=0;
    private String imageURL="";

    public ProductBuilder(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public ProductBuilder description(String description) {
        this.description = description;
        return this;
    }


    public ProductBuilder stockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        return this;
    }

    public ProductBuilder onSale(boolean onSale) {
        this.onSale = onSale;
        return this;
    }

    public ProductBuilder salePercentage(double salePercentage) {
        this.salePercentage = salePercentage;
        return this;
    }

    public ProductBuilder category(int category) {
        this.category = category;
        return this;
    }

    public ProductBuilder imageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }
    public ProductBuilder productId(int productId) {
        this.productId = productId;
        return this;
    }

    public Product build() {
        return new Product(this);
    }

    //--------------------------------------------//


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
