package com.redi.grocery;


import java.util.Scanner;
import java.util.Scanner;

public class Option {


    Scanner input = new Scanner(System.in);

    public void printMenu(){
        System.out.println("1. Choose a Product");
        System.out.println("2. Deliver a Product");
        System.out.println("3. Return a Product");
        System.out.println("4. Search by Product");
        System.out.println("0. Exit");

    }

    public int askService(){
        return this.input.nextInt();
    }
}