package QuestionFifteen;

public class Fifteen implements Mathing {


    @Override
    public void add(double x, double y) {
         double z= x+y;
        System.out.println(z);

    }

    @Override
    public void subtract(double x, double y) {
        double z = x-y;
        System.out.println(z);
    }

    @Override
    public void multiply(double x, double y) {
        double z = x*y;
        System.out.println(z);
    }

    @Override
    public void divide(double x, double y) {
        if(y==0){
            System.out.println("You blew up the world. Don't divide by zero.");
        }else{
            double z = x/y;
            System.out.println(z);
        }
    }
}
