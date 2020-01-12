package _04_threadcommunication;

/**
 * synchronized 版本的生产者消费者模型
 */
public class SynchronizedDemo {
    public static void main(String[] args) throws Exception {
        MySource mySource = new MySource();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    mySource.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    mySource.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    mySource.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    mySource.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class MySource {
    private int number;

    public synchronized void increase() throws InterruptedException {
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + " 蛋糕有 " + number + " 个");

        this.notifyAll();
    }

    public synchronized void decrease() throws InterruptedException {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + " 蛋糕有 " + number + " 个");

        this.notifyAll();
    }
}
