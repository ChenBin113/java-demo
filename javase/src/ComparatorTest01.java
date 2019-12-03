import java.util.Arrays;
import java.util.Comparator;

/**
 * 比较器
 */
public class ComparatorTest01 {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 3, 2, 4, 5, 6, 72, 4, 7, 2, 4};
        Arrays.sort(arr, new MyComparator());
        System.out.println(Arrays.toString(arr));
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
