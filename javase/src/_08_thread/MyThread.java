package _08_thread;

/**
 * 两种方法实现多线程
 * 1.继承 Thread 类
 * 2.实现 Runnable 接口
 *
 * 区别：
 * extends 是继承，一般要增强类的功能使用，重写或添加方法
 * implements 是实现接口
 * 单继承和多实现
 */
public class MyThread {
    public static void main(String[] args) {
        //new MyThread_1().start();
        new Thread(new MyThread_2()).start();

        //只能调用一次 start() 方法，否则报 IllegalThreadStateException
        MyThread_1 mt = new MyThread_1();
        //mt.start();
        mt.start();
    }
}

class MyThread_1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread_1!\t" + "打印奇数");
        for (int i = 1; i <= 100; i = i + 2) {
            System.out.print(i + "\t");
        }
    }
}

class MyThread_2 implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread_2!\t" + "打印偶数");
        for (int i = 2; i <= 100; i = i + 2) {
            System.out.print(i + "\t");
        }
    }
}