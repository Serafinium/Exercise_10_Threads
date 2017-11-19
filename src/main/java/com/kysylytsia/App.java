package com.kysylytsia;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        One one = new One();

        Runnable runnable = new Two();
        Thread two = new Thread(runnable);

        one.start();
        two.start();
    }
}

class One extends Thread {
    @Override
    public void run() {
        for(int i=0; i<5; i++){
            System.out.println("Hello, world");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Two implements Runnable{


    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println("Peace in the peace");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

