package com.redi.grocery;

import java.io.IOException;
import java.time.LocalDateTime;
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

    public void productCustomerPage(String categorySelected, String nameSelected, Customer customer, CartTable cartTable) throws IOException, InterruptedException {
        Product selectedProduct = productTable.getProduct(categorySelected, nameSelected);
        System.out.println("--------------------------------------");
        System.out.println(selectedProduct.getName());
        System.out.println("--------------------------------------");
        System.out.println("Description: " + selectedProduct.getDescription() + ".");
        System.out.println("Price: " + selectedProduct.getPrice() + " euro" + "/" + selectedProduct.getUnit());
        System.out.println("Available stock: " + selectedProduct.getStock());
        System.out.println("---------------------------------------");
        System.out.println("Enter the quantity");
        System.out.println("press 0 for return");
        int quantity = 0 ;
        int orderStatus = 0;
        if(selectedProduct.getStock() == 0){
            System.out.println("*********************************");
            System.out.println("*** Product is out  of  stock ***");
            System.out.println("*********************************");
            TimeUnit.SECONDS.sleep(2);
            Util.clearScreen();
        } else {
            do {
                quantity = scan.nextInt();
                scan.nextLine();
                if (quantity > selectedProduct.getStock()) {
                    System.out.println("Please enter the quantity less than available stock: " + selectedProduct.getStock());
                } else if (quantity < 0) {
                    System.out.println("Invalid input. Please try again.");
                }
            } while (quantity > selectedProduct.getStock() || quantity < 0);
            Util.clearScreen();
            if (quantity > 0) {
                System.out.println("Product added to cart.");
                TimeUnit.SECONDS.sleep(2);
                Util.clearScreen();
                selectedProduct.getId();
                LocalDateTime localDateTime = null;
                Cart cart = new Cart(selectedProduct.getId(), customer.getCustId(), quantity, orderStatus, localDateTime);
                cartTable.write(cart);
            }
        }
    }
    public void productAdminPage(String categorySelected, String nameSelected) throws IOException, InterruptedException {
        Product selectedProduct = productTable.getProduct(categorySelected, nameSelected);
        System.out.println("--------------------------------------");
        System.out.println(selectedProduct.getName());
        System.out.println("--------------------------------------");
        System.out.println("Category: " + selectedProduct.getCategory());
        System.out.println("Description: " + selectedProduct.getDescription() + ".");
        System.out.println("Price: " + selectedProduct.getPrice() + " euro" + "/" + selectedProduct.getUnit());
        System.out.println("Available stock: " + selectedProduct.getStock());
        System.out.println("---------------------------------------");
        System.out.println("choose from below");
        System.out.println("1. Update stock");
        System.out.println("2. Remove product");
        System.out.println("0. Go back");
       int a = Integer.parseInt(scan.nextLine());
        if(a == 1){
            System.out.println("please enter the new stock value");
            int newStockValue = Integer.parseInt(scan.nextLine());
            selectedProduct.setStock(newStockValue);
            productTable.updateProducts();
            System.out.println("Stock value updated");
            TimeUnit.SECONDS.sleep(1);
            Util.clearScreen();
        } else if(a == 2){
            System.out.println("Do you want to remove the product? (y/n)") ;
            String rp = scan.nextLine();
            if(rp.equals("y")){
                productTable.removeProduct(selectedProduct);
                productTable.updateProducts();
                System.out.println("Product removed");
                TimeUnit.SECONDS.sleep(1);
                Util.clearScreen();
            }
        }
    }

}
