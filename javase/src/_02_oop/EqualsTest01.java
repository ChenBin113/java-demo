package _02_oop;

public class EqualsTest01 {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s2.intern() == s1); // false
        System.out.println(s1.intern() == s2); // false
        System.out.println(s1.intern() == s2.intern()); // true

        /*
        说明：new String，s1 指向内存中，查找字符串常量池中有无字符串，有则使用 s1.intern() 能查找到，无则在字符串常量池中新建一个
             然后 s1.intern() 指向它
         */

        Object object = new Object();
        System.out.println(object);
    }
}
