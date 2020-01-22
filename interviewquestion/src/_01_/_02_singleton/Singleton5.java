package _01_._02_singleton;

import java.io.IOException;
import java.util.Properties;

public class Singleton5 {
    private Singleton5(String info) {
        this.info = info;
    }
    public static final Singleton5 INSTANCE;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Singleton5.class.getClassLoader().getResourceAsStream("Singleton.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        INSTANCE = new Singleton5(properties.getProperty("info"));
        System.out.println(properties.getProperty("info"));
    }
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton5{" +
                "info='" + info + '\'' +
                '}';
    }
}
