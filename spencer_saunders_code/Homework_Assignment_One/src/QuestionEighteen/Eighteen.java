package QuestionEighteen;

import java.text.NumberFormat;

import static java.lang.Integer.parseInt;

public class Eighteen extends EighteenAbstract {

    @Override
    boolean checkUpperCase(String s) {
        if(s.toLowerCase().equals(s)){
            return false;
        }return true;
    }

    @Override
    String toUpper(String s) {
        String t = s.toUpperCase();
        return t;
    }

    @Override
    int changetoInt(String s) {
        try{
            int x = parseInt(s);
            return x;
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {

        Eighteen instance = new Eighteen();
        String msg = "hello worLd.";
        String number = "15";

        System.out.println(instance.checkUpperCase(msg));
        System.out.println(instance.toUpper(msg));
        System.out.println(instance.changetoInt(number));



    }
}
