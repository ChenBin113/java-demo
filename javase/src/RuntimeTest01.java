/**
 * Runtime 实例使用的是 单例模式——饿汉式
 */
public class RuntimeTest01 {
    public static void main(String[] args) {
        //Runtime.java
        //private static Runtime currentRuntime = new Runtime();

        System.out.println(Thread.currentThread().getName());
        //获取 cpu 核心数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
