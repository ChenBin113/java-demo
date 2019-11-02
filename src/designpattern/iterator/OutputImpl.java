package designpattern.iterator;

import java.util.Iterator;
import java.util.List;

public class OutputImpl {
    List<College> collegeList;

    public OutputImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    public void printCollege() {
        Iterator<College> iterator = collegeList.iterator();
        while (iterator.hasNext()) {
            College c = iterator.next();
            System.out.println(c.getName());
            printDepartment(c.createIterator());
        }
    }

    public void printDepartment(Iterator iterator) {
        while (iterator.hasNext()) {
            Department d = (Department) iterator.next();
            System.out.println(d.getName());
        }
    }
}
