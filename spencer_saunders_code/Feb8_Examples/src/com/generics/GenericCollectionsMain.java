package com.generics;

import java.util.*;

public class GenericCollectionsMain {
    static List<Integer> numbers = new ArrayList<>();
    static Set<String> names = new HashSet<>();
    static Map<Integer, String> people = new HashMap<>(); //first parameter is type of key, the second is the type of the value

    public static void main(String[] args) {
        numbers.add(1);             // outputs 1, 1, true, and some hash code
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        names.add("Andy");
        names.add("John");          // outputs Andy and John
        names.add("Andy");

        people.put(10, "August");
        people.put(66, "Erica");   // outputs the names and some key code
        people.put(12, "Carla");

        System.out.println("Print Numbers");
        for(Integer i : numbers){
            System.out.println(i);
        }
        System.out.println("\n with an iterator now");
        Iterator itr = numbers.iterator();
        while(itr.hasNext()){
            Integer i = (Integer)itr.next();
            System.out.println(i);
            itr.remove();
        }
        System.out.println("\nAfter the iterator");
        for(Integer i : numbers){
            System.out.println(i);
        }

        System.out.println("\nIterate of the Map's entry set");
        for(Map.Entry<Integer,String> entry : people.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

}


