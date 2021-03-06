package _01_basic._02_singleton;

public class Singleton3 {
    private static volatile Singleton3 INSTANCE;

    private Singleton3() { }

    public static Singleton3 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton3();
                }
            }
        }
        return INSTANCE;
    }
}
