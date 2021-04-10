package com.example.myntra.Model;

import java.util.ArrayList;

public class User {

    String name,email;
    ArrayList<String> cart;
    ArrayList<String> wish;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(String name, String email, ArrayList<String> cart, ArrayList<String> wish) {
        this.name = name;
        this.email = email;
        this.cart = cart;
        this.wish = wish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getCart() {
        return cart;
    }

    public void setCart(ArrayList<String> cart) {
        this.cart = cart;
    }

    public ArrayList<String> getWish() {
        return wish;
    }

    public void setWish(ArrayList<String> wish) {
        this.wish = wish;
    }
}
