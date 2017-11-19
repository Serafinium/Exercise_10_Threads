package com.kysylytsia;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        One one = new One();
        one.start();

        System.out.println("Main thread end!");
    }
}

class One extends Thread{
    @Override
    public void run() {
        Two two = new Two();
        two.start();
    }
}

class Two extends Thread{
    @Override
    public void run() {
        this.setName("TWO");
        for (int i=0; i<3; i++){
            System.out.println(this.getName());
        }
        Three three = new Three();
        three.start();
    }
}

class Three extends Thread{
    @Override
    public void run() {
        this.setName("Three");
        for(int i=0; i<5; i++){
            System.out.println(this.getName());
        }
    }
}