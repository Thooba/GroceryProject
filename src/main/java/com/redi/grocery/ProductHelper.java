package com.redi.grocery;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ProductHelper {
    Scanner scan;
    ProductTable productTable;

    public ProductHelper() throws IOException {

        this.productTable = new ProductTable();
        this.scan = new Scanner(System.in);
    }

    public Product addProduct() throws IOException, InterruptedException {
        System.out.println("Enter product name");
        String name = scan.nextLine();
        System.out.println("what is product description");
        String description = scan.nextLine();
        System.out.println("enter product stock");
        int stock = Integer.parseInt(scan.nextLine());
        System.out.println("enter product price");
        float price = Float.parseFloat(scan.nextLine());
        System.out.println("enter product category");
        String category = scan.nextLine();
        System.out.println("enter product unit" );
        String unit = scan.nextLine();

        Product p = new Product(name, description, stock, price, category, unit);
        this.productTable.write(p);
        Util.clearScreen();
        System.out.println("Product added");
        TimeUnit.SECONDS.sleep(2);
        Util.clearScreen();

        return p;
    }

}
