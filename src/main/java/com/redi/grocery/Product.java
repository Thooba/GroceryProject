package com.redi.grocery;

import java.util.*;

public class Product {
    private final UUID id;
    private final String name;
    private  int stock;
    private int price;
    private final String category;

    public Product(UUID id, String name, int stock, int price, String category) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = category;
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

    public int getPrice() {
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