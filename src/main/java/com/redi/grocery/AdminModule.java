package com.redi.grocery;

import com.redi.grocery.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AdminModule {

        ProductTable pt;
        Scanner scan ;
        Customer customer;
        CartTable cartTable ;
        CustomerTable ct;

    public AdminModule () throws IOException {
            this.customer = customer;
            this.pt = new ProductTable();
            this.scan = new Scanner(System.in);
            this.cartTable = new CartTable();
            this.ct = new CustomerTable();
        }
    public void viewOrders() throws IOException, InterruptedException {
        List<Cart> cartItems = cartTable.getItems(null, 1);
        if(cartItems.isEmpty()){
            System.out.println("No orders yet");
            TimeUnit.SECONDS.sleep(2);
            Util.clearScreen();
        } else {
            System.out.println("All Orders");
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

    public void viewCustomer() throws IOException {
        System.out.println("--------------------------------------------");
       for(Customer c: ct.getCustomers()){
           System.out.println( "name: "+ c.getName());
           System.out.println( "Email: " + c.getEmailId());
           System.out.println("Joining Date: " + c.getDate());
           System.out.println("--------------------------------------------");
       }
        System.out.println("press any key to continue");
        System.in.read();
        Util.clearScreen();

    }
}
