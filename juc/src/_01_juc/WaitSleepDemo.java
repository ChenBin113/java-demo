package _01_juc;

public class WaitSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        //Thread.currentThread().sleep(3000);
        System.out.println("3s 后打印");

        Thread thread = new Thread(() -> {
        }, "A");

        thread.start();
        synchronized (thread) {
            thread.wait();
        }
        System.out.println("A 线程等待");

        thread.notifyAll();
        System.out.println("A 线程唤醒");
    }
}
