package _08_thread;

import java.util.concurrent.TimeUnit;

/**
 * join() alive() 方法测试
 */
public class MethodTest {
    public static void main(String[] args) throws InterruptedException {
        //joinTest();
        aliveTest();

    }

    private static void aliveTest() {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.print("\t计时\t" + i);
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }, "A");

        System.out.println("Thread A is alive:\t" + a.isAlive());
        a.start();
        System.out.println("Thread A is alive:\t" + a.isAlive());
    }

    /**
     * join()
     * 主线程和子线程的关系 main 和 A
     * 也就是 a.join() 执行时，下面代码不再执行，等待 A 线程执行完毕
     * b.join() 执行时，A 线程并不会停止打印，在 main 线程中，A B 两个线程没有关系
     *
     * 总结：
     * X.join() X 线程在某个线程中调用，就形成了主线程和子线程，主线程必须等待子线程执行完毕
     */
    private static void joinTest() throws InterruptedException {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t计时\t" + i + "\t\t");
                try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }, "A");

        Thread b = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "\t计时\t" + i + "\t");
                try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }, "B");

        a.start();
        //a.join();

        b.start();
        b.join();

        System.out.println("MethodTest.main");
    }
}
