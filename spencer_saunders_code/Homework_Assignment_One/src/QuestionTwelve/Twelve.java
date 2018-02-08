package QuestionTwelve;

public class Twelve {
    public static void main(String[] args) {
        int[] cent = new int[100];

        for(int i=0; i<100; i++){
            cent[i]=i+1;
        }
        System.out.println("Even Numbers:");
        for(int number : cent){
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }
    }
}
