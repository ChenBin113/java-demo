package juc._02_cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS 是 compare and swap，比较并交换
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,2020) + "\t" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,1024) + "\t" + atomicInteger.get());

    }
}
