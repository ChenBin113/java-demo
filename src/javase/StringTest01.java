package javase;

/**
 * 测试 String 在 JVM 中的一些使用问题
 */
public class StringTest01 {
    public static void main(String[] args) {
        String s1 = new String("chen");
        String s2 = new String("chen");
        System.out.println(s1 == s2); //false
        System.out.println(s1.equals(s2)); //true

        String s3 = "bin";
        String s4 = "bin";
        System.out.println(s1 == s2); //false
        System.out.println(s1.equals(s2)); //true


        String a = "ab";
        String b = "ab";
        System.out.println(a==b);

    }
}
