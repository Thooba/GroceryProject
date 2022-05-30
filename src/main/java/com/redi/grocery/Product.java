package com.redi.grocery;

import java.util.*;

public class Product {
    private final UUID id;
    private final String name;
    private  int stock;
    private float price;
    private final String category;

    public Product(UUID id, String name, int stock, float price, String category) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = category;
    }

    public Product(String name, int stock, float price, String category){
        this(UUID.randomUUID(),name, stock, price, category);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }
    @Override
    public String toString() {
        return id + "," + name + "," + stock + "," + price + "," + category;
    }
}