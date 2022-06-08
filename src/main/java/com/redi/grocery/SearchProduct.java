package com.redi.grocery;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SearchProduct {
    ProductTable pt;
    Scanner scan ;
    Customer customer;
    CartTable cartTable ;

    public SearchProduct(Customer customer) throws IOException {
        this.customer = customer;
        this.pt = new ProductTable();
        this.scan = new Scanner(System.in);
        this.cartTable = new CartTable();
    }

    public void chooseCategory() throws IOException, InterruptedException {
        List<String> categories = this.pt.getCategories();
        int categoryChoice = 0;
        do {
            System.out.println("choose from below options");
            int pos = 0;
            for (String s : categories) {
                pos += 1;
                System.out.println(pos + ". " + s);
            }
            System.out.println("0. Go Back");
            categoryChoice = scan.nextInt();
            scan.nextLine();
            Util.clearScreen();
            if (categoryChoice > categories.size() || categoryChoice < 0) {
                System.out.println("Invalid input. Please try again");
            } else if (categoryChoice > 0) {
                String categorySelected = categories.get(categoryChoice - 1);
                chooseProduct(categorySelected);
            }

        } while (categoryChoice != 0) ;
    }

    public void chooseProduct(String categorySelected) throws IOException, InterruptedException {
        int nameChoice = 0;
        do {
            System.out.println("Choose product in  " + categorySelected + "category");
            List<String> names = this.pt.getNamesByCategory(categorySelected);
            int pos1 = 0;
            for (String st : names) {
                pos1 += 1;
                System.out.println(pos1 + ". " + st);
            }
            System.out.println("0. Go Back");
            nameChoice = scan.nextInt();
            scan.nextLine();
            Util.clearScreen();
            if (nameChoice > names.size() || nameChoice < 0) {
                System.out.println("Invalid input. Please try again. ");
            } else if (nameChoice > 0) {
                String nameSelected = names.get(nameChoice - 1);
                productPage(categorySelected, nameSelected);
            }
        } while (nameChoice != 0);

    }


    public void productPage(String categorySelected, String nameSelected) throws IOException, InterruptedException {
        Product selectedProduct = pt.getProduct(categorySelected, nameSelected);
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
        do {
            quantity = scan.nextInt();
            scan.nextLine();
            if (quantity > selectedProduct.getStock()) {
                System.out.println("Please enter the quantity less than available stock: " + selectedProduct.getStock());
            }else if(quantity < 0){
                System.out.println("Invalid input. Please try again.");
            }
        } while (quantity > selectedProduct.getStock() || quantity < 0);
        Util.clearScreen();
        if (quantity > 0){
            System.out.println("Product added to cart.");
            TimeUnit.SECONDS.sleep(2);
            Util.clearScreen();
            selectedProduct.getId();
            LocalDateTime localDateTime = null;
            Cart cart = new Cart(selectedProduct.getId(), customer.getCustId(), quantity, orderStatus, localDateTime);
            this.cartTable.write(cart);
        }
    }

    public void viewCart() throws IOException, InterruptedException {
        List<Cart> cartItems = cartTable.getItems(customer,0);
        if( cartItems.isEmpty()){
            System.out.println("cart is empty");
            TimeUnit.SECONDS.sleep(2);
            Util.clearScreen();
        } else {
            float total = 0.0f;
            System.out.println("Your Cart");
            for (Cart c : cartItems) {
                Product p = pt.getProductById(c.getProductId());
                System.out.println("-------------------------------------");
                System.out.println("Category: " + p.getCategory() + "\n" + "Name: " + p.getName() + "\n" + "Quantity: " + c.getQuantity());
                System.out.println("Price: " + p.getPrice() * c.getQuantity());
                total += p.getPrice() * c.getQuantity();
            }
            System.out.println("-------------------------------------");
            System.out.println("Total: " + total);
            System.out.println("-------------------------------------");
            System.out.println("Do you want to place the order? (y/n)");
            String a = scan.nextLine();
            Util.clearScreen();
            if (a.equals("y")) {
                Deliver delivery = new Deliver();
                delivery.getDeliverService();
                TimeUnit.SECONDS.sleep(3);
                Util.clearScreen();
                this.cartTable.updateCartOrderStatus(customer);
            }
        }
    }

    public void viewOrder() throws IOException, InterruptedException {
        List<Cart> cartItems = cartTable.getItems(customer,1);
        if(cartItems.isEmpty()){
            System.out.println("You have not placed any orders yet.");
            TimeUnit.SECONDS.sleep(2);
            Util.clearScreen();
        } else {
            System.out.println("Your Orders");
            for (Cart c : cartItems) {
                Product p = pt.getProductById(c.getProductId());
                System.out.println("-------------------------------------");
                System.out.println("Category: " + p.getCategory() + "\n" + "Name: " + p.getName() + "\n" + "Quantity: " + c.getQuantity());
                System.out.println("Price: " + p.getPrice() * c.getQuantity());
                System.out.println("Ordered Date: " + c.getLocalDateTime());
            }
            System.out.println("-------------------------------------");
            System.out.println("press any key to continue");
            System.in.read();
            Util.clearScreen();
        }
    }

}
