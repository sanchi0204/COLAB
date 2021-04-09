package com.example.myntra.Model;

import java.util.ArrayList;

public class ProductType {

    private String  title, brand;
    private String ProductId,image;
    private int Rating;

    public ProductType() {
    }

    public ProductType(String title, String brand, String productId, String image, int rating) {
        this.title = title;
        this.brand = brand;
        ProductId = productId;
        this.image = image;
        Rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }
}