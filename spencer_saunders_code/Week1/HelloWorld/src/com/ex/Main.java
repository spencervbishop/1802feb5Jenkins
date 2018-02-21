package com.ex;

public class Main {
    private String msg;

    public Main(String msg){
        this.msg=msg;
    }
    public Main(){} //method overloading (need a constructor with no parameters)
    public static void main(String[] args){
       // System.out.println("Hello, World!");
        A a = new A();
        System.out.println("____________");
        B b = new B();
        A c = new B();
        c.m1();
        //c.m2(); Java can't find the method m2 because c is of type A

        Main m = new Main();
        m.sayHello();
    }
    public void sayHello() {
        if (this.msg != null){
            System.out.println(this.msg);
    }else {
            System.out.println("Hello World!");
        }
    }
}
