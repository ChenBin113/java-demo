package oom;

import java.util.Random;

/**
 * JVM 配置：-Xms1m -Xmx1m -XX:+PrintGCDetails
 */
public class OutOfMemoryErrorTest01 {
    public static void main(String[] args) {
        String s = "chenbin113.top";
        while (true) {
            s += new Random().nextInt(8888) + new Random().nextInt(9999);
        }
    }
}
