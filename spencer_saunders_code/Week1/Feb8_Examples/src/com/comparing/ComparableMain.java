package com.comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableMain {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

        p1.setName("Spencer");
        p1.setAge(24);

        p2.setName("Tyler");
        p2.setAge(23);

        if(p1.compareTo(p2)>0){
            System.out.println(p1.getName() + " is older than " + p2.getName());

        }

        List<Person> people = Arrays.asList(p1,p2);
        System.out.println("Before Sorting");
        for(Person p: people){
            System.out.println(p);
        }
        System.out.println("\nAfter Sorting");
        Collections.sort(people);
        for(Person p: people){
            System.out.println(p);
        }

        List<Person> newPeople = Arrays.asList(p1,p2);
        System.out.println("Before Sorting");
        for(Person p: newPeople){
            System.out.println(p);
        }
        System.out.println("\nAfter Sorting");
        Collections.sort(newPeople);
        for(Person p: newPeople){
            System.out.println(p);
        }

    }
}
