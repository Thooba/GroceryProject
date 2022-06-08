package com.redi.grocery;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserLogin {

    Scanner scan;
    Console console;
    CustomerTable customerTable;

    public UserLogin() throws IOException {
        this.customerTable = new CustomerTable();
        this.scan = new Scanner(System.in);
        this.console = System.console();
    }

    public Customer signUpPage() throws IOException, InterruptedException {

        System.out.println("Welcome to awesome groceries shop");
        System.out.println("1.Login");
        System.out.println("2.Register");
        int num = scan.nextInt();
        scan.nextLine();

        if(num == 1){
            return this.login();
        } else {
            return this.registration();
        }
    }

    public Customer login() throws InterruptedException {

        System.out.println("Enter your email");
        String email = scan.next();

        System.out.println("Enter your password");
        String password;
        try {
            password = String.valueOf(this.console.readPassword());
        } catch (NullPointerException e) {
            password = scan.next();
        }

        Customer c = this.customerTable.getCustomer(email, password);
        if(c == null){
            Util.clearScreen();
            System.out.println("Login failed. User email or password did not match");
            TimeUnit.SECONDS.sleep(3);
            Util.clearScreen();
        }
        return c;
    }

    public Customer registration() throws IOException, InterruptedException {
        System.out.println("Whats your name");
        String name = scan.next();
        System.out.println("whats your email_id?");
        String email = scan.next();
        System.out.println("Enter your password");
        String password;
        try {
            password = String.valueOf(this.console.readPassword());
        } catch (NullPointerException e) {
            password = scan.next();
        }
        if(customerTable.validateEmail(email)){
            Util.clearScreen();
            System.out.println("Email already exists. Please login.");
            TimeUnit.SECONDS.sleep(3);
            Util.clearScreen();
            return null;
        }
        Customer c = new Customer(name,email,password);
        this.customerTable.write(c);
        return c;
    }
}
