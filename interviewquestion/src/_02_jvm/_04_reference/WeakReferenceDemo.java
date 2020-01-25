package _02_jvm._04_reference;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {
    public static void main(String[] args) {
        weak();
    }

    /**
     * 弱引用为空马上回收
     */
    public static void weak() {
        Object o = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o);
        System.out.println(o);
        System.out.println(weakReference.get());

        o = null;
        System.out.println("====================");
        System.gc();

        System.out.println(o);
        System.out.println(weakReference.get());
    }
}
