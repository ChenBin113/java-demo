package _09_reflect.car;

import java.io.FileReader;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 反射：使用两种方式读取配置文件的信息
 */
public class Test {
    public static void main(String[] args) throws Exception {
        fun1();
        fun2();
    }

    private static void fun1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ResourceBundle bundle = ResourceBundle.getBundle("_09_reflect/config/config");
        String car = bundle.getString("car");
        Class<?> aClass = Class.forName(car);
        Car c = (Car) aClass.newInstance();
        c.run();
    }

    private static void fun2() {
        Properties p = new Properties();
        try (FileReader fileReader = new FileReader("javase/src/reflect/config/config.properties")) {
            p.load(fileReader);
            Class<?> aClass = Class.forName(p.getProperty("car"));
            Car c = (Car) aClass.newInstance();
            c.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
