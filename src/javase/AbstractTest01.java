package javase;

/**
 * 1.抽象类是可以继承非抽象类的，因为根类 Object 就是一个非抽象类
 * 2.抽象类可以有非抽象的方法
 * 3.继承抽象类的子类为非抽象类时，需要重写抽象父类的抽象方法
 */
public class AbstractTest01 {
    class SuperClass {
        int i = 0;
        String name = "Super";
    }

    abstract class SubClass extends SuperClass {
        public abstract void fun1();
        public void fun2(){};
    }

    class SonClass extends SubClass {
        @Override
        public void fun1() {

        }
    }
}