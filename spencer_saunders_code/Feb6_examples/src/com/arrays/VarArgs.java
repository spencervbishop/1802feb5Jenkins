package com.arrays;

public class VarArgs {

        public static void main(String[] args){
           printArray(new Object[]{1,2,3,4});
           printVarArgs(1,2,3,4,5,6);
        }

        public static void printArray(Object[] args){
            System.out.println();
        }
        public static void printVarArgs(int... ints){   //if you use more than one argument here int... ints must go last
            for(int i:ints){
                System.out.println(i);
            }
        }
}
