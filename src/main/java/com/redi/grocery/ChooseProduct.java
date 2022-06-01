package com.redi.grocery;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ChooseProduct {
    ProductTable pt;
    public ChooseProduct() throws IOException {
        this.pt = new ProductTable();

    }

    public void chooseProduct(){
        Scanner scan = new Scanner(System.in);
        List<String> categories = this.pt.getCategories();
        System.out.println("choose from below options");
        int pos = 0;
        for(String s: categories){
            pos += 1;
            System.out.println(pos + "." + s);
        }
        int num = scan.nextInt();
        System.out.println("Choose product in  " + categories.get(num - 1) + "category");
        List<String> names =this.pt.getNamesByCategory(categories.get(num - 1));
        int pos1 = 0;
        for(String st : names){
            pos1 += 1;
            System.out.println(pos1 +"."+st);
        }
        int num1 = scan.nextInt();
        System.out.println("You choose "+ names.get(num1 - 1));


    }

}
