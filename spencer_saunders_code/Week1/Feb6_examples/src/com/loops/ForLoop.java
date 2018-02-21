package com.loops;

public class ForLoop {
    public static void main(String[] args){
//        int x = 0;
//        for(;;){                                infinite for loop
//            System.out.println("x is " + x++);
//        }
        for(int x=0; x<10; x++){
            System.out.println("x is " + x);
        }//similarly
        for(int x=0;x<10;){
            System.out.println("x is " + x);
            x++;
        }
    }
}
