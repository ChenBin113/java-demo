package _03_gc;

public class T1 {
    public static void main(String[] args) {
        //不是马上执行
        System.gc();

        //后台线程 main 和 gc ，计数 2
        System.out.println(Thread.activeCount());
    }
}
