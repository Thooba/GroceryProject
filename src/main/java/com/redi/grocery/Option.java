package com.redi.grocery;


import java.util.Scanner;
import java.util.Scanner;

public class Option {


    Scanner input = new Scanner(System.in);

    public void printMenu(){
        System.out.println("Please choose a service:  ");
        System.out.println("1. Choose a Product");
        System.out.println("2. View  Cart ");
        System.out.println("3. View Orders");
        System.out.println("0. Logout");

    }

    public int askService(){
        int a = this.input.nextInt();
        input.nextLine();
        return a;


    }
}