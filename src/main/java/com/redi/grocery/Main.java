package com.redi.grocery;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        menu();
    }

    private static void menu() throws IOException, InterruptedException {
        Util.clearScreen();
        UserLogin userLogin = new UserLogin();
        AdminModule am = new AdminModule();
        ProductHelper ph = new ProductHelper();
        Customer customer = null;

        do {
            customer = userLogin.signUpPage();
        } while(customer==null);

        Util.clearScreen();
        System.out.println("Welcome "+ customer.getName() + "!");
        System.out.println("-------------------------------------");

        if(customer.getIsAdmin() == 0) {
            Option options = new Option();
            SearchProduct search = new SearchProduct(customer);
            Deliver deliver = new Deliver();

            while (true) {
                options.printMenu();
                int choice = options.askService();
                Util.clearScreen();
                switch (choice) {
                    case 1:
                        search.chooseCategory();
                        break;
                    case 2:
                        search.viewCart();
                        break;
                    case 3:
                        search.viewOrder();
                        break;
                    case 0:
                        System.out.println("Thank you for using our services!!!!");
                        return;
                }
            }
        } else {
            System.out.println("You are an admin");
            AdminOptions adminOptions = new AdminOptions();

            while (true) {
                int a = adminOptions.options();
                Util.clearScreen();
                switch (a){
                    case 1:
                       am.viewOrders();
                        break;
                    case 2:
                        am.viewCustomer();
                        break;
                    case 3:
                        ph.addProduct();
                        break;
                    case 0:
                        System.out.println("You are logged out");
                        return;


                }

            }

        }
    }
}
