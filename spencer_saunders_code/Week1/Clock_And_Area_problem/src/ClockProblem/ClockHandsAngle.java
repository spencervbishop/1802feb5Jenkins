package ClockProblem;

public class ClockHandsAngle {

    public static void main(String[] args){
        float h=7;
        float m=0;
        float hdegree = (30*(h%12) + m/2);
        float mdegree = (m/60)*360;
        float angle;

        if(hdegree > mdegree){
            angle = hdegree-mdegree;
        }else if(hdegree < mdegree){
            angle = mdegree-hdegree;
        }else{
            System.out.println("The angle is 0 degrees.");
            angle=0;
        }
        if(angle>180.0){
            angle = 360-angle;
            System.out.println("The angle is " + angle +" degrees.");
        }
    }
}
