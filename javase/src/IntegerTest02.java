public class IntegerTest02 {
    public static void main(String[] args) {
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        System.out.println(i1 == i2); // false
        System.out.println(i1.equals(i2));
    }
}
