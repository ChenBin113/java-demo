package javase.collection;

import java.util.ArrayList;

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
