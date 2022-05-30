package com.redi.grocery;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        UserLogin userLogin = new UserLogin();
        Customer c = userLogin.signUpPage();
        System.out.println(c);

    }
}
