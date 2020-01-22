package _01_._06_member;

public class T {
    int i;

    public void test() {
        int i;
        this.i = 100;
        i = 20;
        System.out.println(this.i);
        System.out.println(i);
    }

    public static void main(String[] args) {
        new T().test();
    }
}
