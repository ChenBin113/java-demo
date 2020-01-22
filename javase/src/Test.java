import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (ListIterator<Integer>  listIterator = list.listIterator(); listIterator.hasNext();) {
            if (listIterator.next() == 2) {
                listIterator.remove();
            }
        }
        System.out.println(list);
    }
}
