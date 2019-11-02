package javase.constructor;

public class Test01 {
    public static void main(String[] args) {
        //测试证明，子类如果不重写，编译器也会默认写上 super() 这一行代码
        SubClass subClass = new SubClass();
    }
}
