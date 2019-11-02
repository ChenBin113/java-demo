package pattern;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 100000; i++) {
            System.out.print("stop! ");
        }
    }
}
