package _02_heap;

public class T2 {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println(" 内存条 8G 的 1/4");
        System.out.println("-Xmx: maxMemory " + maxMemory + " 字节 " + (maxMemory / 1024 / 1024) + " MB");

        System.out.println(" 内存条 8G 的 1/16");
        System.out.println("-Xms: total " + totalMemory + " 字节 " + (totalMemory / 1024 / 1024) + " MB");

        while (true) {
            byte[] bytes = new byte[1024 * 100];
        }
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
