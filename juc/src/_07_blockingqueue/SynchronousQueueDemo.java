package _07_blockingqueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\tproduce 1");
                synchronousQueue.put("1");

                System.out.println(Thread.currentThread().getName() + "\tproduce 2");
                synchronousQueue.put("2");

                System.out.println(Thread.currentThread().getName() + "\tproduce 3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\tconsume");
                synchronousQueue.take();

                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\tconsume");
                synchronousQueue.take();

                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\tconsume");
                synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

    }
}
