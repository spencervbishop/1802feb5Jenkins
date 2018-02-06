package QuestionThree;

public class Three {

    public static String reverse(String a){
        int l = a.length();
        for(int i=0;i<l; i++){
            String s = new String(a.substring(0,i)+s);
        }

        }

    public static void main(String[] args) {
        String name = "spencer";
        int n = name.length();
        //char[] array = new char[n];
        String reversea = reverse(name, n);
        System.out.println(reversea);
    }
}
