package _08_thread;

import java.util.concurrent.TimeUnit;

/**
 * 线程状态实验 demo
 */
public class ThreadStateDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        },"A");
        System.out.println(thread.getState());

        thread.start();
        System.out.println(thread.getState());

        thread.yield();
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(thread.getState());

        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(thread.getState());

        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(thread.getState());
    }
}
