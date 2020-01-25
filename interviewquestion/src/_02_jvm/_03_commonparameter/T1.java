package _02_jvm._03_commonparameter;

public class T1 {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("-Xmx: maxMemory = " + maxMemory);
        System.out.println("-Xms: totalMemory = " + totalMemory);
    }
}
