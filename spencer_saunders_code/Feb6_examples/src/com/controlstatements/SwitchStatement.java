package com.controlstatements;

public class SwitchStatement {
    public static void main(String[] args){
        int x = 10;  //can use strings, booleans, whatever

        switch(x){
            case 5: {
                System.out.println("x is 5");
                break; //gotta add that break
            }
            case 10:{
                System.out.println("x is 10");
                break;
            }
            case 15:{
                System.out.println("x is 15");
                break;
            }
            default: {                              //default can go anywhere
                System.out.println("x is " + x);
            }
        }
    }
}
