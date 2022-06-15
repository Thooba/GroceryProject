package com.redi.grocery;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, NoSuchAlgorithmException {
        menu();
    }

    private static void menu() throws IOException, InterruptedException, NoSuchAlgorithmException {
        Util.clearScreen();
        UserLogin userLogin = new UserLogin();
        AdminModule am = new AdminModule();
        ProductHelper ph = new ProductHelper();
        Option options = new Option();
        Customer customer = null;

        do {
            customer = userLogin.signUpPage();
        } while(customer==null);

        Util.clearScreen();
        System.out.println("Welcome "+ customer.getName() + "!");
        System.out.println("-------------------------------------");

        if(customer.getIsAdmin() == 0) {
            SearchProduct search = new SearchProduct(customer);
            while (true) {
                int choice = options.customerOptions();
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
            while (true) {
                int a = options.adminOptions();
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
                    case 4:
                        SearchProduct search = new SearchProduct(customer);
                        search.chooseCategory();
                    case 0:
                        System.out.println("You are logged out");
                        return;


                }

            }

        }
    }
}
