package com.ex;

public class A {
    private int x;

    public static int y;

    {
        System.out.println("Instance block 1");
        x=7;
    }

    static{
        System.out.println("Static Block 1");  //notice that this line prints first because statics are processed at load time
    }

    public A(){
        System.out.println("constructs A");
    }
    public void m1(){
        System.out.println("m1");
    }
}
