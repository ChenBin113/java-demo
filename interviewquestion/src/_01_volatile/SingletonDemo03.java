package _01_volatile;

/**
 * 增加 volatile 关键字，禁止指令重排
 */
public class SingletonDemo03 {
    private static volatile SingletonDemo03 instance = null;

    private SingletonDemo03() {
        System.out.println(Thread.currentThread().getName() + "\t SingletonDemo03.SingletonDemo()");
    }

    public static SingletonDemo03 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo03.class) {
                if (instance == null) {
                    instance = new SingletonDemo03();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SingletonDemo03.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
