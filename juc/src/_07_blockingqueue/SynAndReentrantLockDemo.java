package _07_blockingqueue;

import java.util.concurrent.locks.ReentrantLock;

/**
 * javap 查看 syn 和 lock 的区别
 */
public class SynAndReentrantLockDemo {
    public static void main(String[] args) {
        synchronized (new Object()) {

        }

        new ReentrantLock();
    }
}
