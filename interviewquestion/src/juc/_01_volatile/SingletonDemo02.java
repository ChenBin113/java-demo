package juc._01_volatile;

/**
 * 单例模式 DCL Double Check Lock
 * 在多线程下极少概率出现问题，原因是：
 * getInstance() 方法中语句可能受编译器和处理器的指令优化作用而进行重排
 */
public class SingletonDemo02 {
    private static SingletonDemo02 instance = null;

    private SingletonDemo02() {
        System.out.println(Thread.currentThread().getName() + "\t SingletonDemo02.SingletonDemo()");
    }

    public static SingletonDemo02 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo02.class) {
                if (instance == null) {
                    instance = new SingletonDemo02();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SingletonDemo02.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
