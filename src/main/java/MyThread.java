/**
 * Created by SERAFIM on 18.11.2017.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("I study Java");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
