package com.redi.grocery;

import java.io.*;
import java.util.*;

public class ProductTable {
    private final String path ="src/data/product.csv";
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
                                        items[2],
                                        Integer.parseInt(items[3]),
                                        Float.parseFloat(items[4]),
                                        items[5],
                                        items[6]));
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
           bufferedWriter.write(product.toString() +System.lineSeparator());
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
        for(Product p : this.products){
            name.add(p.getName());
        }
        return name;
    }

    public List<String> getNamesByCategory(String category) {
        List<String> names = new ArrayList<>();
        for(Product p : products) {
            if (p.getCategory().equals(category)) {
              names.add(p.getName());
            }
        }

        return names;
    }

    public Product getProduct(String category,String name){
        for(Product p : products){
            if(p.getCategory().equals(category) && p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public Product getProductById(UUID custId){
        for(Product p : products){
            if(p.getId().equals(custId)){
                return p;
            }
        }
        return null;
    }
}
