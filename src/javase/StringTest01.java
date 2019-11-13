package javase;

/**
 * 测试 String 在 JVM 中的一些存储位置
 * 字符串常量池位于堆中
 * new String() 则是在堆的另一片区域开辟内存
 */
public class StringTest01 {
    public static void main(String[] args) {
        String s1 = new String("chen");
        String s2 = new String("chen");
        System.out.println(s1 == s2); //false，说明不是同一个对象
        System.out.println(s1.equals(s2)); //true，说明 String 的 equals 方法重写，比较的值相同

        String s3 = "bin";
        String s4 = "bin";
        System.out.println(s3 == s4); //true，说明是同一个对象
        System.out.println(s3.equals(s4)); //true，说明比较的值相同
    }
}
