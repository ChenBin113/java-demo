package jvm._05_error;

public class T {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
        //Exception in thread "main" java.lang.IllegalThreadStateException
    }
}
