package _02_juc._04_arraylist;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全的问题
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        //java.util.ConcurrentModificationException

        listIsNotSafe();

        setIsNotSafe();

        //HashSet<String> set = new HashSet<>();

        mapIsNotSafe();
    }

    public static void mapIsNotSafe() {
        Map<String, String> map = new ConcurrentHashMap<>();//Collections.synchronizedMap(new HashMap<>());//new HashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    public static void setIsNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();//Collections.synchronizedSet(new HashSet<>());//new HashSet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    public static void listIsNotSafe() {
    /*
    1.底层是？Object[]
    2.初始容量是？10
    3.一开始不是那么大，添加元素不超过 10 默认扩容为 10
    4.不够初始容量怎么办？扩容
    5.扩容多少？1.5
     */
        /*
        ArrayList<String> list1 = new ArrayList<>();
        System.out.println(list1.size());
        list1.add("a");
         */

        /*
        6.安全不？不安全
        7.写个例子
         */
        /*
        流式编程
        List<String> list2 = Arrays.asList("a", "b", "c");
        list2.stream().forEach(System.out::println);
        list2.forEach(System.out::println);
         */

        /* 出现并发问题，ArrayList 线程不安全 */
        //List<String> list3 = new ArrayList<>();

        /* 1.使用 Vector 类，synchronized 的 ArrayList ，JDK1.0 */
        //List<String> list3 = new Vector<>();

        /* 2.使用 Collections 的方法 */
        //List<String> list = new ArrayList<>();
        //List<String> list3 = Collections.synchronizedList(list);

        /* 3.使用 CopyOnWriteList */
        List<String> list3 = new CopyOnWriteArrayList<>();

        /*
        list3.add("a");
        list3.add("b");
        list3.add("c");

        for (String s : list3) {
            System.out.println(s);
        }
        */

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list3.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list3);
            }, String.valueOf(i)).start();
        }
    }
}
