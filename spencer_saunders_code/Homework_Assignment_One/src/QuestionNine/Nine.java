package QuestionNine;

public class Nine {

    public static boolean isPrime(int n) {
        int count = 0;
        if (n <= 1) {
            return false;
        } else {
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    count++;
                }
            }
            if (count > 1) {
                return false;
            }
            if (count == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] array = new int[100];
        array[0] =1;

        int[] primes = new int[100];
        int index = 0;
        for(int i=1; i<100; i++){
            array[i] = i+1;
            if(isPrime(i+1)){
                primes[index] = i+1;
                index++;
            }
        }
        System.out.println("Array:");
        for(int j=0; j<20; j++){
            System.out.println(array[j]);
        }
        System.out.println("Primes:");
        for(int k=0; k<20; k++){
            System.out.println(primes[k]);
        }
    }
}
