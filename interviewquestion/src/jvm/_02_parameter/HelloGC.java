package jvm._02_parameter;

/**
 * jps -l
 * jinfo -flag
 * jinfo -flags
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("*****HelloGC");
        Thread.sleep(1000000);
    }
}
