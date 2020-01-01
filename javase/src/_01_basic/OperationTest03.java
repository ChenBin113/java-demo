package _01_basic;

/**
 * 比较运算符
 */
public class OperationTest03 {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        System.out.println(i == j); //false
        System.out.println(i = j); //20

        String s = "chenbin113.top";
        System.out.println(s == null); //false
        System.out.println(s = null); //null
    }
}
