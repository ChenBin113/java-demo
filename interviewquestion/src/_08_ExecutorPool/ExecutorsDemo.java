package _08_ExecutorPool;

import java.util.concurrent.*;

/**
 * 1.线程池的使用：三种方法
 * 2.自定义线程池
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
        //threadPoolInit();
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()); //抛出异常，临界值为 max + BlockingQueue
                //new ThreadPoolExecutor.CallerRunsPolicy()); //返回给调用该线程的线程处理
                //new ThreadPoolExecutor.DiscardOldestPolicy()); //扔掉最老的任务
                //new ThreadPoolExecutor.DiscardPolicy()); //直接扔掉任务

        try {
            for (int i = 1; i <= 9; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t执行线程");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public static void threadPoolInit() {
        //ExecutorService executorService = Executors.newFixedThreadPool(5);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            for (int i = 1; i <= 9; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 线程处理");
                    //try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
