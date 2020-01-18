package juc._07_blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 由于打印和取值不同步，有可能打印出来不是按照顺序，但是实际上就是先生产一个，然后消费一个
 */
public class ProdConsumerBlockingQueueDemo {
    public static void main(String[] args) {
        MySource mySource = new MySource(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t生产线程启动");
            try {
                mySource.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产线程").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t消费线程启动");
            System.out.println();
            System.out.println();
            try {
                mySource.myConsume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费线程").start();

        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("5s 时间到，暂停");
        mySource.stop();
    }
}

class MySource {
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue;

    public MySource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(this.blockingQueue.getClass().getName() + "\t==============传入的阻塞队列类型\n");
    }

    public void myProd() throws InterruptedException {
        String data;
        boolean retValue = false;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t数据\t" + data + "\t插入队列成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t数据\t" + data + "\t插入队列失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t停止，表示 flag = " + retValue);
    }

    public void myConsume() throws InterruptedException {
        String result;
        while (flag) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "超过 2s 没有消费，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t消费队列\t" + result + "\t成功");
        }
        System.out.println("结束");
    }

    public void stop() {
        flag = false;
    }
}