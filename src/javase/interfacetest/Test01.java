package javase.interfacetest;

@FunctionalInterface
public interface Test01 {
    /*
    函数式接口只有一个未实现的方法
    可以有多个 default 方法
     */
    void fun1();

    default void fun2() {

    }

    default void fun3() {

    }
}
