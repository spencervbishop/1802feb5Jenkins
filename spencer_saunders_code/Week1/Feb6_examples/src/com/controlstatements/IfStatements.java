package com.controlstatements;

public class IfStatements {
    public static void main(String[] args){

        int x=5;
        if(x==10){
            System.out.println("x is equal to 10");
        }else{
            System.out.println("x is not equal to 10");
        }

        if(x>10){
            System.out.println("x is greater than 10");
        }else if(x<10){
            System.out.println("x is less than 10");
        }else{
            System.out.println("x is equal to 10.");
        }
    }
}
