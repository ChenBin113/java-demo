package _02_oop;

import java.util.HashSet;

public class PersonTest01 {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 18);
        Person person2 = new Person("zhangsan", 18);
        Person person3 = new Person("lisi", 18);
        Person person4 = new Person("wangwu", 20);

        //=======================================================
        // hashCode() 得到的是对象存放的地址的十进制数
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person1);
        System.out.println(person2);
        HashSet set = new HashSet();

        set.add(person1);
        set.add(person2);
        set.add(person3);
        set.add(person4);
        set.add(person1);

        System.out.println(set);

    }
}
