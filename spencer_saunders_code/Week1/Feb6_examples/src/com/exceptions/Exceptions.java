package com.exceptions;

public class Exceptions {

    public static void main(String[] args) {
        try{
            Class.forName(Object.class.getName());
            System.out.println("Hi");
        }catch (ClassNotFoundException e) {     //or ReflectiveOperationException or Exception
            e.printStackTrace();                //you can do a multi catch with more exceptions
        }finally{
            System.out.println("this runs no matter what.");
        }
        System.out.println("Hi Again!");



        System.out.println(div(100, 10));
      try{
          System.out.println(div(100,0));
      }catch(ArithmeticException e){
          e.printStackTrace();
        }


//        loadClass();    //right click and handle the exception
    }
//        public static void loadClass() throws ClassNotFoundException{
//            Class.forName(Object.class.getName());
//
//        }
public static int div(int x, int y) {
    return x / y;
}

//    public static int div(int x, int y) throws ArithmeticException{   //smarter way
//        if(y==0){
//            throw new ArithmeticException("Check your input");
//        }
//        return x/y;
//    }

}


class BadMathException extends Exception{ //checked exception, if you extend runtime exception it becomes unchecked
    public BadMathException(String msg){
        super(msg);}
}
