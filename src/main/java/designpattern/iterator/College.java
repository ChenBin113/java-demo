package designpattern.iterator;

import java.util.Iterator;

public interface College {

    public String getName();

    public void addDepartment(String name, String des);

    public Iterator createIterator();
}
