package com.generics;

import com.comparing.Person;

public class EqualsMain {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

        p1.setName("Spencer");
        p1.setAge(25);

        p2.setName("Spencer");
        p2.setAge(25);

        if(p1.equals(p2)){
            System.out.println("P1 and P2 are equal");
        }else{
            System.out.println("P1 and P2 are not equal");  //this is gonna happen because they don't have the same memory address
        }
    }
}
