/**
 * Created by SERAFIM on 18.11.2017.
 */
public class App extends Thread {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.setName("my thread");
        myThread.start();

        System.out.println( myThread.getName() );
    }


}
