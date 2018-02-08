package com.threads;

public class ThreadsMain {

}

class EvenRunnable implements Runnable{

    public static void main(String[] args) {

        Thread thread1 = new Thread(new EvenRunnable(), "EvenThread");
        Thread thread2 = new Thread(new OddRunnable(), "OddThread");
        Thread thread3 = new OtherThread("OtherThread");

        thread1.start();
        thread2.start();        //watch the crazy sporadic behavior!
        thread3.start();

        //BLOCK UNTL THREAD 1 IS COMPLETE
        try{
            thread1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Main Thread");
    }

    @Override
    public void run() {
        int limit = 100;
        int start = 0;

        while(start <= limit){
            System.out.println(start);
            start += 2;
        }
    }
}

class OddRunnable implements Runnable {

    @Override
    public void run() {
        int limit = 100;
        int start = 1;

        while (start <= limit) {
            System.out.println(start);
            start += 2;
        }
    }
}

class OtherThread extends Thread{
    public OtherThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("THIS IS THE ODD MAN OUT.");
    }
}