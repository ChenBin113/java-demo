package _08_thread;

import java.util.concurrent.TimeUnit;

/**
 * 测试：
 * 不同线程调用同一对象的同步方法和非同步方法
 *
 * 结论：
 * 同步方法不能同时调用，非同步不受此限制
 */
public class SynchronizedTest01 {

    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> {
            print.printA();
        }, "A").start();

        new Thread(() -> {
            print.printB();
        }, "B").start();


        try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> {
            print.printA();
        }, "A").start();

        new Thread(() -> {
            print.printX();
        }, "X").start();
    }
}

class Print {
    synchronized void printA() {
        System.out.println("我是 " + Thread.currentThread().getName() + " 线程，我已经调用了 printA() ，但是我要休息 3s");
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("A");
    }

    synchronized void printB() {
        System.out.println("我是 " + Thread.currentThread().getName() + " 线程，我等了 A 线程 3s ，这货终于好了，我赶紧打印");
        System.out.println("B");
    }

    void printX() {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("我是 " + Thread.currentThread().getName() + " 线程，我看 A 线程要休息 3s ，我休息 1s 后赶紧打印");
        System.out.println("X");
    }
}
