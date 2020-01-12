package designpattern.strategy;

import java.util.Arrays;

public class ComparatorTest01 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 5, 5, 6, 71, 4, 7};
        Arrays.sort(arr, (var1, var2) -> {
            if (var1.compareTo(var2) > 0) {
                return 1;
            } else {
                return -1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
