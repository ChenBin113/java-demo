package _02_juc._03_atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 学习 AtomicStampedReference 类
 * 规避 ABA 问题
 */
public class ABADemo {

    /*
    T1 100 -> 2019
    T2 100 -> 101  -> 100

    T1 100 1 -> 2019 2
    T2 100 1 -> 101 2  -> 100 3
     */
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        System.out.println("============ ABA 问题的产生 ============");
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t当前值为：\t" + atomicReference.get());
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "\t修改值成功：\t" + atomicReference.compareAndSet(100, 101));
            System.out.println(Thread.currentThread().getName() + "\t修改值成功：\t" + atomicReference.compareAndSet(101, 100));
        }, "t1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t当前值为：\t" + atomicReference.get());
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "\t修改值成功：\t" + atomicReference.compareAndSet(100, 2019));
            System.out.println(Thread.currentThread().getName() + "\t当前值为：\t" + atomicReference.get());
        }, "t2").start();


        try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("============ ABA 问题的解决 ============");
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t版本1\t" + stamp + "\t值\t" + atomicStampedReference.getReference());
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t版本2\t" + atomicStampedReference.getStamp() + "\t值\t" + atomicStampedReference.getReference());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t版本3\t" + atomicStampedReference.getStamp() + "\t值\t" + atomicStampedReference.getReference());
        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t版本1\t" + stamp + "\t值\t" + atomicStampedReference.getReference());
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            boolean flag = atomicStampedReference.compareAndSet(100, 2019, stamp, atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t修改成功\t" + flag);
            System.out.println(Thread.currentThread().getName() + "\t版本2\t" + atomicStampedReference.getStamp() + "\t值\t" + atomicStampedReference.getReference());
        }, "t4").start();

        /*
        output:
        t3	版本1	1	值	100
        t4	版本1	1	值	100
        t3	版本2	2	值	101
        t3	版本3	3	值	100
        t4	修改成功	false
        t4	版本2	3	值	100

        结果解释：
        t3 线程的版本和打印时间戳一致
        t4 线程的版本和打印时间戳不一致 且更新值失败
         */
    }
}
