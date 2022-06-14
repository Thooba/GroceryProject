package com.redi.grocery;

import java.util.Scanner;

public class AdminOptions {
    public int options(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please choose a service:");
        System.out.println("1.View Customers Orders");
        System.out.println("2.View Customers");
        System.out.println("3.Update Product");
        System.out.println("0.Logout");
        int a = scan.nextInt();
        return a;


    }
}
