package com.kysylytsia;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {

        One one = new One();
        Two two = new Two();
        Three three = new Three();

        one.start();
        two.start();
        three.start();

    }
}

class One extends Thread{
    @Override
    public void run() {
        this.setName("ONE!");
        this.setPriority(10);
        for (int i=0; i<5; i++){
            System.out.println("In thread " + this.getName());
            this.yield();
        }
    }
};


class Two extends Thread{
    @Override
    public void run() {
        this.setName("TWO!");
        this.setPriority(10);
        for (int i=0; i<5; i++){
            System.out.println("In thread " + this.getName());
            this.yield();
        }
    }
};


class Three extends Thread{
    @Override
    public void run() {
        this.setName("THREE!");
        this.setPriority(1);
        for (int i=0; i<5; i++){
            System.out.println("In thread " + this.getName());
        }
    }
}