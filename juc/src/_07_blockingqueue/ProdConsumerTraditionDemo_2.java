package _07_blockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock condition await() signal() signalAll()
 */
public class ProdConsumerTraditionDemo_2 {
    public static void main(String[] args) {
        DataTwo data = new DataTwo();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                data.increase();
            }, "A").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                data.decrease();
            }, "B").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                data.increase();
            }, "C").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                data.decrease();
            }, "D").start();
        }
    }

}

class DataTwo {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increase() {
        lock.lock();
        try {
            while (this.number != 0) {
                condition.await();
            }
            this.number++;
            System.out.println(Thread.currentThread().getName() + "\t" + this.number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrease() {
        lock.lock();
        try {
            while (this.number == 0) {
                condition.await();
            }
            this.number--;
            System.out.println(Thread.currentThread().getName() + "\t" + this.number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
