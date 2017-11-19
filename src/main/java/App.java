
/**
 * Hello world!
 *
 */

class App implements Runnable {

    First a = new First();
    Second b = new Second();

    App() {
        Thread.currentThread().setName("First thread");
        Thread t = new Thread(this, "Second thread");
        t.start();

        a.foo(b);

        System.out.println("back in to first thread");
    }

    public void run() {
        b.bar(a);

        System.out.println("back in to second thread");
    }

    public static void main(String args[]) {
        new App();
    }
}



class First {

    synchronized void foo(Second b) {

        String name = Thread.currentThread().getName();
        System.out.println(name + " go in method First.foo()");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("class First break");
        }

        System.out.println(name + " try call method Second.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("in method First.last()");
    }
}



class Second {

    synchronized void bar(First a) {

        String name = Thread.currentThread().getName();
        System.out.println(name + " go in method Second.bar()");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("class Second break");
        }

        System.out.println(name + " try call method First.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("in method Second.last()");
    }
}


