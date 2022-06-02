package com.redi.grocery;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SearchProduct {
    ProductTable pt;
    Scanner scan ;

    public SearchProduct() throws IOException {
        this.pt = new ProductTable();
        this.scan = new Scanner(System.in);
    }

    public void chooseCategory() {
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
            if (categoryChoice > categories.size() || categoryChoice < 0) {
                System.out.println("Invalid input. Please try again");
            } else if (categoryChoice > 0) {
                String categorySelected = categories.get(categoryChoice - 1);
                chooseProduct(categorySelected);
            }

        } while (categoryChoice != 0) ;

    }

    public void chooseProduct(String categorySelected) {
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
            if (nameChoice > names.size() || nameChoice < 0) {
                System.out.println("Invalid input. Please try again. ");
            } else if (nameChoice > 0) {
                String nameSelected = names.get(nameChoice - 1);
                productPage(categorySelected, nameSelected);
            }
        } while (nameChoice != 0);

    }


    public void productPage(String categorySelected, String nameSelected){
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
        do {
            quantity = scan.nextInt();
            if (quantity > selectedProduct.getStock()) {
                System.out.println("Please enter the quantity less than available stock: " + selectedProduct.getStock());
            }else if(quantity < 0){
                System.out.println("Invalid input. Please try again.");
            }
        } while (quantity > selectedProduct.getStock() || quantity < 0);

        if (quantity > 0){
            System.out.println("adding to cart");
        }

    }

}
