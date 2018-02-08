package QuestionTwenty;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Twenty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new FileReader("resources/data"));
            String line;
            int count = 0;

            while((line = reader.readLine()) != null){
                count++;
                String[] data = line.split(":");
                System.out.println("Name: " + data[0] + " " + data[1]);
                System.out.println("Age: " + data[2] + " years");
                System.out.println("State: " + data[3] + " state");
                System.out.println("     ");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            reader.close();
        }
    }
}
