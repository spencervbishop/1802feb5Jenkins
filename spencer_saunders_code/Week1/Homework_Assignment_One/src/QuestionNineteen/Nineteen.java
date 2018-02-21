package QuestionNineteen;

import QuestionNine.Nine;
import java.util.ArrayList;

public class Nineteen {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>(10);
        ArrayList<Integer> primes = new ArrayList<Integer>(1);
        Integer evensum = 0;
        Integer oddsum = 0;


        for(Integer i=0; i<=9; i++){
            numbers.add(i+1);
            if((i+1)%2==0){
                evensum = evensum+i+1;
            }else{
                oddsum = oddsum+i+1;
            }
        }
        System.out.println(numbers);
        System.out.println("Even sum: " + evensum);
        System.out.println("Odd sum: "+ oddsum);

        for(Integer element : numbers){
            if(Nine.isPrime(element)){
                primes.add(element);
            }
        }

        for(Integer prime : primes){
            numbers.remove(prime);

        }
        System.out.println(numbers);
    }
}
