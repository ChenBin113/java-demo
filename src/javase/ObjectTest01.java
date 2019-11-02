package javase;

public class ObjectTest01 implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectTest01 objectTest01 = new ObjectTest01();
        Object clone = objectTest01.clone();
        System.out.println(objectTest01 == clone);
        System.out.println(objectTest01);
        System.out.println(clone);
    }
}
