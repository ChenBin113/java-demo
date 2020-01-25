package _02_juc._04_arraylist;

public class TransferValue {

    public void transferInt(int age) {
        age = 30;
    }

    public void transferString(String s) {
        s = "xxx";
    }

    public void transferName(Person person) {
        person.name = "ChenBin";
    }

    public static void main(String[] args) {
        /*
        stack
        heap
        字符串常量池
         */
        TransferValue test = new TransferValue();
        int age = 20;
        test.transferInt(age);
        System.out.println("age = 20 是否改变\t");
        System.out.println("\t false\t" + age);

        Person person = new Person();
        test.transferName(person);
        System.out.println("Person.name = \"human\" 是否改变");
        System.out.println("\t true\t" + person.name);

        String s = "abc";
        test.transferString(s);
        System.out.println("s = \"abc\" 是否改变");
        System.out.println("\t false\t" + s);
    }
}

class Person {
    String name = "human";
}
