package AreaProblem;

public class InterestingArea {
    public static void main(String[] args){
        int area_1 = 1;
        //odd square with 4 extras
        for(int n=3; n<=20; n++){
            int area = 2*n*n-2*n+1; //only for n>=2
            System.out.println("Area of shape is: " + area);
        }
    }
}
