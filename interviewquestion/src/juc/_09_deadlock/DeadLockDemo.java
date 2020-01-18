package juc._09_deadlock;

import java.util.concurrent.TimeUnit;

/**
 * 死锁：使用
 * jps -l
 * jstack [process_id]
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        new Thread(new HoldLock("lockA", "lockB"), "A 线程").start();
        new Thread(new HoldLock("lockB", "lockA"), "B 线程").start();
    }

}


class HoldLock implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t持有锁" + lockA);
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() +  "\t持有锁" + lockB);
            }
        }
    }
}