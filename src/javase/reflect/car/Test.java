package javase.reflect.car;

        import java.io.FileReader;
        import java.io.IOException;
        import java.util.Properties;
        import java.util.ResourceBundle;

/**
 * 反射：使用两种方式读取配置文件的信息
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        fun1();
        fun2();
    }

    public static void fun1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ResourceBundle bundle = ResourceBundle.getBundle("javase/reflect/config/config");
        String car = bundle.getString("car");
        Class<?> aClass = Class.forName(car);
        Car c = (Car) aClass.newInstance();
        c.run();
    }

    public static void fun2() {
        Properties p = new Properties();
        try (FileReader fileReader = new FileReader("src/javase/reflect/config/config.properties")) {
            p.load(fileReader);
            Class<?> aClass = Class.forName(p.getProperty("car"));
            Car c = (Car) aClass.newInstance();
            c.run();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
