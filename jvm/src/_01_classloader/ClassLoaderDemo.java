package _01_classloader;

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
