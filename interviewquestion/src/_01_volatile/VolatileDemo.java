package _01_volatile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {
    public static void main(String[] args) {
        seeOkByVolatile();

        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }

        //等待上面的线程运行结束
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t int \t" + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger \t" + myData.atomicInteger);
    }

    public static void seeOkByVolatile() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println("in A thread");
            //确保 main 线程进入 loop
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
        }, "A").start();

        while (myData.number == 1) {

        }
    }
}

class MyData {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        this.number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addMyAtomic() {
        atomicInteger.getAndIncrement();
    }
}
