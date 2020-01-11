package _08_ExecutorPool;

/**
 * 合理配置线程池
 * maxPoolSize
 *
 * CPU 密集型：
 * 核数 + 1
 *
 * IO 密集型：
 * 1.核数 * 2
 * 2.核数 / ( 1 - 阻塞系数 ) 阻塞系数 = 0.8 ~ 0.9
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
