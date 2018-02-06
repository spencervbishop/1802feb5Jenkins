package QuestionThree;

public class Three {

    public static String myReverse(String a){
        int l = a.length();
        char[] cArray = a.toCharArray();
        char[] reverseArray = new char[l];
        for(int i=0; i<l; i++){
            reverseArray[i] = cArray[l-i-1];
        }
        String reversed = new String(reverseArray);
        return reversed;

        }

    public static void main(String[] args) {
        String name = "it's not true, i did not hit her, its bullshit. i did not hit her. i did naht. oh hi mark";
        System.out.println(myReverse(name));


    }
}
