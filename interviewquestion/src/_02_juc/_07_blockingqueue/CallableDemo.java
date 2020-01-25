package _02_juc._07_blockingqueue;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //实现了 Callable 接口
        MyThread myThread = new MyThread();
        //中间人 FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);

        //中间人和 Thread 认识，使用第三个构造方法，创建线程的哪一种方法最终都是创建线程为目的
        new Thread(futureTask, "A").start();

        //多个线程计算一个 FutureTask 只需要计算一次
        //想要计算多次，需要使用多个 FutureTask
        new Thread(futureTask, "B").start();

        //int result02 = futureTask.get();

        int result01 = 100;
        System.out.println(Thread.currentThread().getName() + "*********");

        //要求获取 Callable 线程的计算结果，如果没有计算完成就要去强求，会导致堵塞，直到计算完成
        int result02 = futureTask.get();
        System.out.println("result = " + (result01 + result02));
    }

}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("****** come in Callable");
        //计算 2s
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        return 1024;
    }
}