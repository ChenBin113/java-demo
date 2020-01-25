package _02_jvm._04_reference;

public class StrongReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Object o2 = o1;
        System.out.println(o1);
        System.out.println(o2);

        o1 = null;
        System.gc();

        Thread.sleep(1000);
        System.out.println(o1);
        System.out.println(o2);
    }
}
