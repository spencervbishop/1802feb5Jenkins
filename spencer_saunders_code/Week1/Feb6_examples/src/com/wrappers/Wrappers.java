package com.wrappers;

public class Wrappers {
    int x = 10;
    Integer y = 10; //autoboxing
    String s = "Cat";

    public static void main(String[] args){
        Wrappers w = new Wrappers();
        System.out.println(w.x + w.y);
    }

}
