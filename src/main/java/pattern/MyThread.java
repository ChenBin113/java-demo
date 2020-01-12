package pattern;

public class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.print("run! ");
        }
    }
}
