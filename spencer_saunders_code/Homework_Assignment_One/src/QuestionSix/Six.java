package QuestionSix;

public class Six {
    public static void main(String[] args){
        int N=11;
        int M=10;
        isEven(N);
        isEven(M);

    }
    static void isEven(int n){ //could replace "void" with "boolean" and "Syso" with "return"
        double nn = n;
        if(nn/2 == java.lang.Math.floor(nn/2)){
            System.out.println("True");
        }else{
            System.out.println("False");}
    }
}
