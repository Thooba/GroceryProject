package com.redi.grocery;


import java.util.Scanner;
import java.util.Scanner;

public class Option {


    Scanner input = new Scanner(System.in);

    public int customerOptions(){
        System.out.println("Please choose a service:  ");
        System.out.println("1. Choose a Product");
        System.out.println("2. View  Cart ");
        System.out.println("3. View Orders");
        System.out.println("0. Logout");
        return Integer.parseInt(this.input.nextLine());
    }

    public int adminOptions(){
        System.out.println("Please choose a service:");
        System.out.println("1. View Customers Orders");
        System.out.println("2. View Customers");
        System.out.println("3. Add Product");
        System.out.println("4. Update Product");
        System.out.println("0. Logout");
        return Integer.parseInt(this.input.nextLine());
    }
}