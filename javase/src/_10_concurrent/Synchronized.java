package _10_concurrent;

/**
 * 查看反编译后源码，方法上有 synchronized 相关
 * javap -verbose [classname]
 */
public class Synchronized {
    public synchronized void synMethod() {
        System.out.println();
    }
}
