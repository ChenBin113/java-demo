package _02_jvm._04_reference;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {
    public static void main(String[] args) {
        //memoryEnough();
        memoryNotEnough();
    }

    /**
     * 此处不会产生 gc 因此手动调用 gc，但是软引用不会变为 null
     */
    private static void memoryEnough() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(softReference.get());

        o = null;
        System.gc();

        System.out.println(o);
        System.out.println(softReference.get());
    }

    /**
     * 此处会产生 gc 使得软引用变为 null
     */
    private static void memoryNotEnough() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(softReference.get());

        o = null;

        try {
            Byte[] bytes = new Byte[1024 * 1024 * 20];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o);
            System.out.println(softReference.get());
        }
    }
}
