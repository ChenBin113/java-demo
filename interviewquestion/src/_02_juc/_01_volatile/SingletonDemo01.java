package _02_juc._01_volatile;

/**
 * 单例模式在多线程下存在问题
 */
public class SingletonDemo01 {
    private static SingletonDemo01 instance = null;

    private SingletonDemo01() {
        System.out.println(Thread.currentThread().getName() + "\t SingletonDemo01.SingletonDemo()");
    }

    public static SingletonDemo01 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo01();
        }
        return instance;
    }

    public static void main(String[] args) {
        //main 单线程环境
        //System.out.println(SingletonDemo01.getInstance() == SingletonDemo01.getInstance());
        //System.out.println(SingletonDemo01.getInstance() == SingletonDemo01.getInstance());
        //System.out.println(SingletonDemo01.getInstance() == SingletonDemo01.getInstance());

        //多线程环境，单例模式不止一个实例对象
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SingletonDemo01.getInstance();
            }, String.valueOf(i)).start();
        }

        /*
        output:
        1	 SingletonDemo01.SingletonDemo()
        0	 SingletonDemo01.SingletonDemo()
         */
    }
}