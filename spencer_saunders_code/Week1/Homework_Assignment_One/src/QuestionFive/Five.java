package QuestionFive;

public class Five {

    public static String mySubstring(String a, int n){
        char[] cArray = a.toCharArray();
        char[] subArray = new char[n];
        for(int i=0; i<n; i++){
            subArray[i] = cArray[i];
        }
        String substring = new String(subArray);
        return substring;
    }
    public static void main(String[] args) {
        int idx = 5;
        String message = "Ive got a bad feeling about this.";
        System.out.println(mySubstring(message, idx));


    }
}
