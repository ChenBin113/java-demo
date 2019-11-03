package javase.abstracttest;

public class AbstractTest01 {
    public static void main(String[] args) {

    }
}

class SuperClass {
    int i = 0;
    String name = "Super";
}

abstract class SubClass extends SuperClass {
    public abstract void fun1();
}

class SonClass extends SubClass {

    @Override
    public void fun1() {

    }
}

