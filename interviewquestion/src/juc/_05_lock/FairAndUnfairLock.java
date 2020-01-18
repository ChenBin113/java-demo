package juc._05_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.公平/非公平：
 *  1.1 先来后到；
 *  1.2 先抢先得，先来后到
 *  1.3 可否插队，默认是可以的，优点是吞吐量高
 */
public class FairAndUnfairLock {
    public static void main(String[] args) {
        ReentrantLock unFairLock = new ReentrantLock();
        ReentrantLock fairLock = new ReentrantLock(true);
    }
}
