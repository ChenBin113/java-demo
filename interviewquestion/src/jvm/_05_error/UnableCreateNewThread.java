package jvm._05_error;

import java.util.concurrent.TimeUnit;

public class UnableCreateNewThread {
    public static void main(String[] args) { 
        /*for (int i = 1; ; i++) {
            System.out.println("i = " + i);
            new Thread(() -> {
                try { TimeUnit.SECONDS.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }, String.valueOf(i)).start();
        }*/
    }
}
