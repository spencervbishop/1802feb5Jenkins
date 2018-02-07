package QuestionFour;

public class Four {
    public static void main(String[] args){
        int N = 5; //replace N with whatever
        factorial(N);
    }

    static void factorial(int n){  //replace "void" with "int" and "System.out.println" with "return" as necessary
        int product = 1;
        if(n<0){
            System.out.println("Can't compute a negative factorial.");
        }if(n==0){
            System.out.println(1);
        }else{
            for(int i=1; i<=n; i++){
                product = product*i;
            }
            System.out.println(product);
        }
    }
}
