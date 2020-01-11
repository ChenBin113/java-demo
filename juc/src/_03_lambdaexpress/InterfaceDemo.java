package _03_lambdaexpress;

/**
 * 1.lambda 表达式
 * 2.一个没有实现的方法
 * 3.default 的方法，可多个
 * 4.static 的方法，可多个
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        /*Foo foo = new Foo() {
            @Override
            public void test() {
                System.out.println("test");
            }
        };*/

        Foo foo = (x) -> {
            System.out.println("test");
        };
        foo.fun1(5);
    }
}

@FunctionalInterface
interface Foo {
    void fun1(int x);

    default void fun2() {

    }

    default void fun3() {

    }

    static void fun4() {

    }

    static void fun5() {

    }
}
