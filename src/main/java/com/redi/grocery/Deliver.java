package com.redi.grocery;


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


    public void getType(int deliver_method) {
        if (deliver_method== 1) {
            System.out.println("Your delivery cost is 10 Euros and will be in 2 hours delivered");
        } else if ( deliver_method== 2){
            System.out.println("Your delivery cost is 5 Euros and will be today in 6 hours delivered");
        } else{
            System.out.println("Your delivery cost is 3 Euros and will be tomorrow delivered");
        }
    }

    public void getDeliverCost(int deliver_cost) {
        if (deliver_cost== 10) {
            System.out.println("Your delivery cost is done and you receive your order in 2 hours");
        } else if ( deliver_cost== 5){
            System.out.println("Your delivery cost is done and you will receive your order in 6 hours ");
        } else{
            System.out.println("Your delivery cost is done and you will receive your order tomorrow");
        }
    }
}