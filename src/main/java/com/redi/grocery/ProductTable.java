package com.redi.grocery;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ProductTable {
    private final String path ="/Users/apple/workspace/redi-java-intermediate/GroceryProject/src/data/product.csv";
    private final String splitBy =",";
    private List<Product> products;

    public ProductTable() throws IOException {
       String line;
       products = new ArrayList<>();
       BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
       try {
           while ((line = bufferedReader.readLine()) != null) {
               String[] items = line.split(splitBy);
               products.add(new Product(UUID.fromString(items[0]),
                                        items[1],
                                        Integer.parseInt(items[2]),
                                        Float.parseFloat(items[3]),
                                        items[4]));
           }
       } finally {
           try {
               bufferedReader.close();
           } catch (IOException e) {
               e.printStackTrace();
           }

       }
    }

   public  void write(Product product) throws IOException {
       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
       try {
           bufferedWriter.newLine();
           bufferedWriter.write(product.toString());
       }  finally  {
           try {
               bufferedWriter.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

   }




}
