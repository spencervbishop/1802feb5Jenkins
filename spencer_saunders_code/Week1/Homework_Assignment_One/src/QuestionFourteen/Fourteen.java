package QuestionFourteen;

import java.lang.Math;
import java.text.DateFormat;
import java.util.Date;

public class Fourteen {
    public static void main(String[] args) {

        int x = 3;
        int number=-49;

        Date date = new Date();

        String msg = "I am learning Core Java.";


        switch (x) {
            case 1: {
                System.out.println(Math.sqrt(Math.abs(number)));
                break;
            }
            case 2: {
                System.out.println(date);
                break;
            }
            default: {
                String array[] = msg.split(" ");
                for (String word : array) {
                    System.out.println(word);
                }

            }
        }
    }
}
