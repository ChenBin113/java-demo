public class IntegerTest01 {
    public static void main(String[] args) {
        Integer i1 = new Integer(10);
        Integer i2 = 10;
        System.out.println(i1 == i2); // false

        String s = "abc";
        change(s);
        System.out.println(s);


    }

    private static void change(String a) {
        System.out.println("============================");
        System.out.println(a);
        a = "a";
        System.out.println(a);
        System.out.println("============================");
    }

}
