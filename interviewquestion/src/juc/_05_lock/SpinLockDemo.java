package juc._05_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)) {

        }
        //此处可以延缓 A 释放锁后 B 立即获得锁的时间，因为 B 一直在 while 循环，一旦打破循环，就会立刻打印出 change successful
        try { TimeUnit.MILLISECONDS.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(Thread.currentThread().getName() + "\tchange successful");
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        try { TimeUnit.MILLISECONDS.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\tchange again");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            //A 持有锁 2s
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.myUnLock();
        }, "A").start();

        //确保 A 线程先拿到锁
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(() -> {
            spinLockDemo.myLock();
            spinLockDemo.myUnLock();
        }, "B").start();

    }
}
