package _06_collection.list;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListAndLinkedListTest {
    public static void main(String[] args) {
        List arrayList = Arrays.asList(new ArrayList(10000));
        Instant time1 = Instant.now();
        for (int i = 0; i < arrayList.size(); i++) {
        }
        Instant time2 = Instant.now();
        System.out.println(time1);
        System.out.println(time2);
    }
}
