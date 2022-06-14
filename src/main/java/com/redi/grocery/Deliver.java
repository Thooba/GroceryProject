package com.redi.grocery;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Deliver {

    double amount;
    int type;
    String reference;

    //constructor

    public Deliver() {

    }
    public Deliver ( int type, double amount){
        this.amount = amount;
        this.type = type;
        this.reference = null;
    }

    public double getAmount(){
        return this.amount;
    }

    public int getType(){
        return this.type;
    }

    public String toString(){
        return "amount: " + this.getAmount() + " type: " + this.getType() + "";
    }

    public String getReference(){
        return this.reference;
    }


    public void getDeliverService() throws InterruptedException {


        Deliver deliver = new Deliver();
        Scanner input = new Scanner(System.in);
        System.out.println("Which delivery service you like?\n1. by car\n2. by bike\n3. by post");
        int deliver_method = input.nextInt();
        deliver.getType(deliver_method);
        System.out.println("Please make the payment for delivery:");
        int deliver_cost = input.nextInt();
        deliver.getDeliverCost(deliver_cost);
    }


    public void getType(int deliver_method) {
        if (deliver_method== 1) {
            System.out.println("Your delivery cost is 10 Euros and will be delivered in 2 hours.");
        } else if ( deliver_method== 2){
            System.out.println("Your delivery cost is 5 Euros and will be delivered today in 6 hours.");
        } else{
            System.out.println("Your delivery cost is 3 Euros and will be deliver tomorrow");
        }
    }

    public void getDeliverCost(int deliver_cost) throws InterruptedException {
        if (deliver_cost== 10) {
            System.out.println("Your delivery cost is done and you receive your order in 2 hours");
        } else if ( deliver_cost== 5){
            System.out.println("Your delivery cost is done and you will receive your order in 6 hours ");
        } else{
            System.out.println("Your delivery cost is done and you will receive your order tomorrow");
        }
    }

}