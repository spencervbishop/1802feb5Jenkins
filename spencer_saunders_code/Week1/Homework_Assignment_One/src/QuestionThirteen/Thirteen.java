package QuestionThirteen;

import java.util.Arrays;

public class Thirteen {
    public static void main(String[] args) {
        int[][] iArray = new int[4][4];
        iArray[0] = new int[]{0};
        iArray[1] = new int[]{1,0};
        iArray[2] = new int[]{1,0,1};
        iArray[3] = new int[]{0,1, 0, 1};

        for(int i = 0; i<4; i++){
               String s = Arrays.toString(iArray[i]);
              String news = s.replace("[","").replace("]","").replace(",", " ");
            System.out.println(news);
        }
//        int count = 0;
//        for(int i=0; i<5; i++){
//            String message;
//            //count++%2
//            System.out.println(message);
//        }
    }
}
