package _01_._02_singleton;

public class Singleton4 {
    private Singleton4() {

    }

    private static class Inner {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return Inner.INSTANCE;
    }
}
