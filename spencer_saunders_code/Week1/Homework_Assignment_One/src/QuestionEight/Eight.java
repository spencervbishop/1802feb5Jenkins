package QuestionEight;

import java.util.*;
import java.io.*;

public class Eight {


    public static void main(String[] args) throws IOException{
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> palindromes = new ArrayList<String>();

        words.add("karan");
        words.add("madam");
        words.add("tom");
        words.add("civic");
        words.add("radar");
        words.add("sexes");
        words.add("jimmy");
        words.add("kayak");
        words.add("john");
        words.add("refer");
        words.add("billy");
        words.add("did");


        for(int i=0; i<words.size(); i++){
            if(words.get(i).equals(QuestionThree.Three.myReverse(words.get(i)))){
                palindromes.add(words.get(i));
            }
        }

        System.out.println("The list of all words is: ");
        for(int k=0; k<words.size(); k++){
            System.out.println(words.get(k));
        }

        System.out.println("----------");
        System.out.println("The list of palindromes is: ");
        for(int j=0; j<palindromes.size(); j++){
            System.out.println(palindromes.get(j));
        }
    }

}
