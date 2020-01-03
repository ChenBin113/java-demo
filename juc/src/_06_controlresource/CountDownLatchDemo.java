package _06_controlresource;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        //closeLibrary();

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i < 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t国被灭了");
                countDownLatch.countDown();
            }, CountryEnum.forEach(i)).start();
        }

        countDownLatch.await();
        System.out.println("================秦国一统华夏");
    }

    public static void closeLibrary() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t还在图书馆");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println("================图书馆闭馆了");
    }
}