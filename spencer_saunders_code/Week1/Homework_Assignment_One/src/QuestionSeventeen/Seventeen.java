package QuestionSeventeen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Seventeen {
    public static void main(String[] args) {

        boolean x = true;
        double principal = 0;
        double rate = 0;
        double time = 0;

        while(x) {              //if user enters data of improper type, the process repeats until user enters a proper value
            System.out.println("Enter the Principal amount:");
            try {
                 principal = new Scanner(System.in).nextDouble();
                x = false;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                x=true;
            }
        }

        x=true;
        while(x) {
            System.out.println("Enter the interest rate as a decimal:");
            try {
                 rate = new Scanner(System.in).nextDouble();
                x = false;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                x = true;
            }
        }

        x=true;
        while(x) {
            System.out.println("Enter the time in years:");
            try {
                 time = new Scanner(System.in).nextDouble();
                x = false;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                x = true;
            }
        }

        double interest = principal*rate*time;
        System.out.println("Interest is: $"+interest+".");


    }
}
