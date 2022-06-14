package com.redi.grocery;

public final class Util {

    private Util(){}

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
