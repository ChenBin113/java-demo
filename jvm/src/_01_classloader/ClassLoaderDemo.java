package _01_classloader;

/**
 * 1. JVM 系统架构图
 *
 * 2. 类加载器
 *  2.1 有哪几种类加载器
 *  2.2 双亲委派
 *  2.3 沙箱安全机制
 *
 * 3. Native
 *  3.1 native 是一个关键字
 *  3.2 声明有，实现无
 *
 * 4. PC 寄存器
 *  4.1 记录了方法之间的调用和执行情况，类似排班值日表
 *  用来存储指向下一条指令的地址，即将要执行的指令代码
 *  它是当前线程所执行的字节码的行号指示器
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoaderDemo classLoaderDemo = new ClassLoaderDemo();
        System.out.println(classLoaderDemo.getClass().getClassLoader());
        System.out.println(classLoaderDemo.getClass().getClassLoader().getParent());
        System.out.println(classLoaderDemo.getClass().getClassLoader().getParent().getParent());

        /*
        sun.misc.Launcher$AppClassLoader@18b4aac2
        sun.misc.Launcher$ExtClassLoader@1b6d3586
        null
         */

        Object o = new Object();
        System.out.println(o.getClass().getClassLoader());
        System.out.println(o.getClass().getClassLoader().getParent());

        /*
        null
        Exception in thread "main" java.lang.NullPointerException
         */
    }
}
