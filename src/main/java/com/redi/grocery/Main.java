package com.redi.grocery;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        menu();
        ChooseProduct chose = new ChooseProduct();
        chose.chooseProduct();
    }

    private static void menu() throws IOException {

        UserLogin userLogin = new UserLogin();
        Customer c = null;
        Option options  = new Option();
        ChooseProduct chose = new ChooseProduct();
        Deliver deliver1 = new Deliver();
        Scanner input = new Scanner(System.in);

        do {
            c = userLogin.signUpPage();
        } while(c==null);

        while(true){
            System.out.println("Please choose a service:  ");
            options.printMenu();

            int choice = options.askService();
            switch(choice){
                case 1:
                    System.out.println("service 1");
                    break;
                case 2:
                    System.out.println("Which delivery service you like, 1 by car  , 2  by bike, 3 by post");
                    int deliver_method = input.nextInt();
                    deliver1.getType(deliver_method);
                    System.out.println("You should pay the deliver cost?");
                    int deliver_cost = input.nextInt();
                    deliver1.getDeliverCost(deliver_cost);
                    break;
                case 3:
                    System.out.println("service 3");
                    break;
                case 4 :
                    System.out.println("service 4");
                    break;
                case 0:
                    System.out.println("Thank you for using our services!!!!");
                    return;
            }
        }
    }
}
