package javase;

/**
 * 1.函数式接口只有一个未实现的方法
 * 2.可以有多个 default 方法
 */
@FunctionalInterface
public interface InterfaceTest01 {

    void fun1();

    default void fun2() {

    }

    default void fun3() {

    }
}
