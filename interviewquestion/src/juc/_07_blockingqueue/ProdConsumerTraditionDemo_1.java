package juc._07_blockingqueue;

/**
 * synchronized notify() wait() notifyAll()
 */
public class ProdConsumerTraditionDemo_1 {
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

class DataOne {
    private int number = 0;

    public void increase() {
        synchronized (this) {
            while (this.number != 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.number++;
            System.out.println(Thread.currentThread().getName() + "\t" + this.number);
            this.notifyAll();
        }
    }

    public void decrease() {
        synchronized (this) {
            while (this.number == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.number--;
            System.out.println(Thread.currentThread().getName() + "\t" + this.number);
            this.notifyAll();
        }
    }
}
