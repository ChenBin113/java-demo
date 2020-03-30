package _02_oop;

/**
 * 抽象类是可以继承非抽象类的，因为根类 Object 就是一个非抽象类
 * 抽象类中可以有抽象方法和非抽象方法
 */
public class AbstractTest01 {

    class SuperClass {
        int i = 0;
        String name = "Super";
    }

    abstract class SubClass extends SuperClass {
        public abstract void fun1();
        public void fun2(){}
    }

    class SonClass extends SubClass {
        @Override
        public void fun1() {

        }
    }

}