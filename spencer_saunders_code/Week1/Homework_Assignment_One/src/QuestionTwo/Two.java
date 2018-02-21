package QuestionTwo;

public class Two {
    public static void main(String[] args){
        final int f0 = 0;
        final int f1 = 1;
        int[] fibonacci = new int[25];

        fibonacci[0] = f0;
        fibonacci[1] = f1;

        for(int i=0; i<=22; i++){
            fibonacci[i+2] = fibonacci[i+1] + fibonacci[i];
        }
        for(int n=0; n<=24; n++){
            System.out.println(fibonacci[n]);
        }
    }
}
