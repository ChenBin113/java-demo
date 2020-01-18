package juc._04_arraylist;

import java.util.*;

/**
 * 1.Collections.synchronizedList 接口中的 RandomAccess
 *  1.1 标记，犹如 Cloneable Serializable 接口一般
 *  1.2 ArrayList 实现了，LinkedList 没有
 *  1.3 这个标记实现后，遍历前要加 synchronized 锁
 *
 * 2.Collections.synchronizedList 的对象遍历的时候，要加 synchronized 锁
 *  2.1 因为其他方法都是有加 synchronized 的代码块，但是 iterator() 没有
 *  2.2 Vector 则都是同步方法
 *
 * 3.Collections.synchronized 适用于不用 Iterator 和性能要求不高的场景
 */
public class RandomAccessTimeTest {

    //使用for循环遍历
    public static long traverseByLoop(List list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    //使用迭代器遍历
    public static long traverseByIterator(List list) {
        Iterator iterator = list.iterator();
        long startTime = System.currentTimeMillis();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        //加入数据
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            arrayList.add("" + i);
        }
        long loopTime = RandomAccessTimeTest.traverseByLoop(arrayList);
        long iteratorTime = RandomAccessTimeTest.traverseByIterator(arrayList);
        System.out.println("ArrayList:");
        System.out.println("for 循环遍历时间:" + loopTime);
        System.out.println("迭代器遍历时间:" + iteratorTime);

        List<String> linkedList = new LinkedList<>();
        //加入数据
        for (int i = 0; i < 3000; i++) {
            linkedList.add("" + i);
        }
        loopTime = RandomAccessTimeTest.traverseByLoop(linkedList);
        iteratorTime = RandomAccessTimeTest.traverseByIterator(linkedList);
        System.out.println("LinkedList:");
        System.out.println("for循环遍历时间:" + loopTime);
        System.out.println("迭代器遍历时间:" + iteratorTime);
    }
}

