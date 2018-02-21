package com.ex;

public class Scopes {

    private int x;
    public static String name = "charles";

    public Scopes(int x){
        this.x = x;
    }
    public static void main(String[] args){
        Scopes s = new Scopes(10);
        System.out.println(s.x);
        System.out.println(s.name);
    }

}
