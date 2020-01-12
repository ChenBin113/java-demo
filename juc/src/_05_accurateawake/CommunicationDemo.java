package _05_accurateawake;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 轮流打印：A 线程打印 5 次，B 线程打印 10 次，C 线程打印 15 次；循环 10 轮
 */
public class CommunicationDemo {
    public static void main(String[] args) {
        MyDataTwo myDataTwo = new MyDataTwo();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    myDataTwo.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    myDataTwo.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    myDataTwo.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }

}

class MyDataTwo {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lock();
        try {
            while (number != 1) {
                c1.await();
            }
            number = 2;
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " 线程，数字为 " + i);
            }
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void print10() throws InterruptedException {
        lock.lock();
        try {
            while (number != 2) {
                c2.await();
            }
            number = 3;
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " 线程，数字为 " + i);
            }
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException {
        lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            number = 1;
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + " 线程，数字为 " + i);
            }
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
