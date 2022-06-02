package com.redi.grocery;

import java.io.IOException;
import java.util.Scanner;

public class ProductHelper {
    Scanner scan;
    ProductTable productTable;

    public ProductHelper() throws IOException {

        this.productTable = new ProductTable();
        this.scan = new Scanner(System.in);
    }

    public Product addProduct() throws IOException {
        System.out.println("Enter product name");
        String name = scan.next();
        System.out.println("what is product description");
        String description = scan.next();
        System.out.println("enter product stock");
        int stock = Integer.parseInt(scan.next());
        System.out.println("enter product price");
        float price = Float.parseFloat(scan.next());
        System.out.println("enter product category");
        String category = scan.next();
        System.out.println("enter product unit");
        String unit = scan.next();

        Product p = new Product(name, description, stock, price, category, unit);
        this.productTable.write(p);
        return p;



    }

}
