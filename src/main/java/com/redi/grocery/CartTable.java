package com.redi.grocery;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class CartTable {
    private final String path = "src/data/cart.csv";
    private final String splitBy = ",";



    public  List<Cart> getItems(Customer customer, int orderStatus) throws IOException {
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<Cart> cartItems = new ArrayList<>();
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] items = line.split(splitBy);
                LocalDateTime d = null;
                if (!items[4].equals("null")){
                    d = LocalDateTime.parse(items[4]);
                }
                Cart cart = new Cart(UUID.fromString(items[0]),
                                     UUID.fromString(items[1]),
                                     Integer.parseInt(items[2]),
                                     Integer.parseInt(items[3]),
                                     d);
                if (customer == null){
                    if (orderStatus == 0 || orderStatus == 1 ){
                        if (cart.getOrderStatus() == orderStatus){
                            cartItems.add(cart);
                        }
                    } else {
                        cartItems.add(cart);
                    }
                } else if (customer.getCustId().equals( cart.getCustId()) && cart.getOrderStatus() == orderStatus) {
                    cartItems.add(cart);
                }
            }
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cartItems;
    }

    public void write(Cart cart) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
        try {
            bufferedWriter.write(cart.toString()  + System.lineSeparator());
        }  finally  {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateCartOrderStatus(Customer customer) throws IOException {
        List<Cart> cartItems = getItems(null,-1);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        try {
            LocalDateTime date =LocalDateTime.now();
            for(Cart c : cartItems){
                if(customer.getCustId().equals(c.getCustId()) && c.getOrderStatus() == 0) {
                    c.setOrderStatus(1);
                    c.setLocalDateTime(date);
                }
                bufferedWriter.write(c.toString() + System.lineSeparator());
            }
        }  finally  {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
