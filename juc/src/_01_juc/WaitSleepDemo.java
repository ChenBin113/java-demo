package _01_juc;

import java.util.concurrent.TimeUnit;

public class WaitSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("sleep 方法，精确 3s 后打印");
        Thread.currentThread().sleep(3000);
        System.out.println("3s 结束");

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 线程启动后休息 3s");
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        }, "A");

        thread.start();
        //IllegalMonitorStateException
        //thread.wait(3000);
    }
}
