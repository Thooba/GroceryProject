package com.redi.grocery;

import java.io.IOException;
import java.util.Scanner;

public class UserLogin {

    Scanner scan;
    CustomerTable customerTable;

    public UserLogin() throws IOException {
        this.customerTable = new CustomerTable();
        this.scan = new Scanner(System.in);
    }

    public Customer signUpPage() throws IOException {

        System.out.println("Welcome to awesome groceries shop");
        System.out.println("1.Login");
        System.out.println("2.Register");
        int num = scan.nextInt();

        if(num == 1){
            return this.login();
        } else {
            return this.registration();
        }
    }

    public Customer login(){

        System.out.println("Enter your email");
        String email = scan.next();

        System.out.println("Enter your password");
        String password = scan.next();

        Customer c = this.customerTable.getCustomer(email, password);
        if(c == null){
            System.out.println("Login failed. User email or password did not match");
        }else{
            System.out.println("Welcome back "+ c.getName());
        }
        return c;
    }

    public Customer registration() throws IOException {
        System.out.println("Whats your name");
        String name = scan.next();
        System.out.println("whats your email_id?");
        String email = scan.next();
        System.out.println("new password");
        String password = scan.next();
        if(customerTable.validateEmail(email)){
            System.out.println("Email already exists. Please login.");
            return null;
        }
        Customer c = new Customer(name,email,password);
        this.customerTable.write(c);
        return c;
    }
}
