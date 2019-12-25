package class01_juc;

public class ThreadDemo {
    public static void main(String[] args) {
        //1.线程的状态
        //Thread.State

        System.out.println("before");

        //2.wait / sleep
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A Thread!");
        }, "A").start();

        System.out.println("end");
    }
}
