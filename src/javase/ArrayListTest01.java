package javase;

import java.util.ArrayList;

/**
 * 1.没有使用泛型，会导致整个集合的数据类型混乱
 */
public class ArrayListTest01 {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add("hello");
        arrayList.add(1.1);
        arrayList.add(null);
        System.out.println(arrayList);
        System.out.println(arrayList.get(0) instanceof Integer);
    }

}
