package jvm._05_error;

public class JavaHeapSpaceErrorDemo {
    public static void main(String[] args) {
        Byte[] bytes = new Byte[1024 * 1024 * 80];
        //80m but heap set 10m
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
