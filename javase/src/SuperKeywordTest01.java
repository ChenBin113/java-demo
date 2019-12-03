/**
 * 测试证明，子类如果不重写，编译器也会默认写上 super() 这一行代码
 */
public class SuperKeywordTest01 {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
    }

    static class SuperClass {
        public SuperClass() {
            System.out.println("Super");
        }
    }

    static class SubClass extends SuperClass {
        //public SubClass() {
        //    super();
        //}
    }
}

