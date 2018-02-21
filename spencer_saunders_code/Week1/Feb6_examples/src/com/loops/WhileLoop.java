package com.loops;

public class WhileLoop {
    public static void main(String[] args){
        int x=0;

        while(x<10){
            System.out.println("x is " + x);
            x++;
            }

            while(true){
                System.out.println("x is " + x);
                x++;
                if(x>10){break;}
        }
            while(true){
            x++;
            if(x%2 ==0){
                continue;
            }
                System.out.println("x is "+ x);
                if(x>=10){break;}
            }

            //do()while()
    }
}
