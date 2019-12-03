import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorTest02 {
    public static void main(String[] args) {
        Person p1 = new Person(1, "张三");
        Person p2 = new Person(2, "李四");
        Person p3 = new Person(3, "王五");

        TreeSet<Person> set = new TreeSet<>(new IdComparator());
        set.add(p1);
        set.add(p2);
        set.add(p3);

        for (Person p :
                set) {
            System.out.println(p);
        }
    }

}

class Person {
    private int id;
    private String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class IdComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o2.getId() - o1.getId();
    }
}