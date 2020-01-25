package _01_basic._02_singleton;

public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1() { }
}
