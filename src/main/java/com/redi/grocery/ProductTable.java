package com.redi.grocery;

import java.io.*;
import java.util.*;

public class ProductTable {
    private final String path ="/Users/apple/workspace/redi-java-intermediate/GroceryProject/src/data/product.csv";
    private final String splitBy =",";
    private final List<Product> products;

    public ProductTable() throws IOException {
       String line;
       this.products = new ArrayList<>();
       BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
       try {
           while ((line = bufferedReader.readLine()) != null) {
               String[] items = line.split(splitBy);
               this.products.add(new Product(UUID.fromString(items[0]),
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

    public List<String> getCategories() {
        Set<String> categories = new HashSet<>();
        for(Product p : this.products){
            categories.add(p.getCategory());
        }
        return new ArrayList<>(categories);

    }

    public List<String> getNames(){
      List<String> name = new ArrayList<String>();
        for(Product a : this.products){
            name.add(a.getName());
        }
        return name;
    }

    public List<String> getNamesByCategory(String category) {
        List<String> names = new ArrayList<>();
        for(Product s : products) {
            if (s.getCategory().equals(category)) {
              names.add(s.getName());
            }
        }

        return names;
    }
}
