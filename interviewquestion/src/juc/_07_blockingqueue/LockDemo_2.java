package juc._07_blockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo_2 {
    public static void main(String[] args) {
        DataFour dataFour = new DataFour();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                dataFour.print(5);
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                dataFour.print(10);
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                dataFour.print(15);
            }
        }, "C").start();
    }
}

class DataFour {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print(int time) {
        lock.lock();
        try {
            switch (time) {
                case 5:
                    while (number != 1) {
                        c1.await();
                    }
                    for (int i = 0; i < time; i++) {
                        System.out.println(Thread.currentThread().getName() + "\t" + number);
                    }
                    number = 2;
                    c2.signal();
                    break;
                case 10:
                    while (number != 2) {
                        c2.await();
                    }
                    for (int i = 0; i < time; i++) {
                        System.out.println(Thread.currentThread().getName() + "\t" + number);
                    }
                    number = 3;
                    c3.signal();
                    break;
                case 15:
                    while (number != 3) {
                        c3.await();
                    }
                    for (int i = 0; i < time; i++) {
                        System.out.println(Thread.currentThread().getName() + "\t" + number);
                    }
                    number = 1;
                    c1.signal();
                    break;
                default:
                    System.out.println("wrong time");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
