package _02_juc._07_blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);

        blockingQueue.add("a");
        blockingQueue.remove();
        blockingQueue.element();

        blockingQueue.offer("a");
        blockingQueue.poll();
        blockingQueue.peek();

        blockingQueue.put("a");
        blockingQueue.take();

        blockingQueue.offer("a", 2, TimeUnit.SECONDS);
        blockingQueue.poll(2, TimeUnit.SECONDS);

    }
}
