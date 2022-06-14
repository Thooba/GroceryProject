package com.redi.grocery;

import java.util.*;

public class Product {
    private final UUID id;
    private final String name;
    private final String description;
    private  int stock;
    private float price;
    private final String category;
    private final String unit;

    public Product(UUID id, String name, String description, int stock, float price, String category,String unit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.category = category;
        this.unit = unit;
    }

    public Product(String name, String description, int stock, float price, String category, String unit){
        this(UUID.randomUUID(),name, description, stock, price, category, unit);
    }




    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + description + "," + stock + "," + price + "," + category + "," + unit;
    }
}