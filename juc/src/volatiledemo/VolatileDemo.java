package volatiledemo;

import java.util.concurrent.TimeUnit;

/**
 * volatile 保证了变量在多线程运行下的可见性：seeOkByVolatile()
 * volatile 不保证原子性：atomicNotOkByVolatile()
 */
public class VolatileDemo {
    public static void main(String[] args) {
        //seeOkByVolatile();
        atomicNotOkByVolatile();
    }

    public static void atomicNotOkByVolatile() {
        MyData myData = new MyData();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        //两个线程：一个 main 线程，一个 gc 线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t" + myData.number);
    }

    public static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t in ThreadA");
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t number change to 60 \t" + myData.number);
        }, "ThreadA").start();

        while (myData.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t number != 0");
    }
}

class MyData {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    public synchronized void addPlusPlus() {
        this.number++;
    }
}
