package com;

public class StringsApi {
    @Override
    public String toString() {  //right click and select "Generate"
        return "StringsApi{}";
    }

    public static void main(String[] args){
        String s = new String("Cat");
        String f = "Dog";
       // s+"food"; can't change the value of s. we can only change the object it points to and we create new strings
       String t = s.concat("food");
        System.out.println(s);
        System.out.println(t);


    }
}
