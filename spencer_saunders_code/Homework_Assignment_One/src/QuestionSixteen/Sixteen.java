package QuestionSixteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sixteen {
    public static void main(String[] args) throws IOException {

        System.out.println("Please enter any message:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String message = reader.readLine();
        System.out.println(message.length());
    }
}
