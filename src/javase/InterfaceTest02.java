package javase;

/**
 * 1.接口是可以 new 的，只要重写它的方法
 * 2.接口具有 Object 的 public 方法，但不继承 Object 类
 */
public class InterfaceTest02 {
    public static void main(String[] args) {
        A a = new A() {
            @Override
            public void fun1() {

            }
        };
        int i = a.hashCode();
        System.out.println("i = " + i);
    }

    interface A {
        void fun1();
    }
}

