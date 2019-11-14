package javase;

/**
 * 1.父类引用指向子类对象，只能使用父类本身的成员变量
 * 2.强制类型转换后，就可以使用子类的成员变量
 * 3.instanceof 测试结果表明，一个类的对象 instanceof 类 / 父类，返回 true；一个类的对象 instanceof 子类 / 其他类，false
 */
public class PlymorphismTest01 {
    class FatherClass {
        private String name = "Father";
    }

    class SonClass extends FatherClass {
        String name = "Son";
    }

    public void fun1() {
        FatherClass f = new SonClass();
        System.out.println(f.name); //Father
        System.out.println("-------------- 父类转为子类 --------------");
        System.out.println(((SonClass) f).name); //Son
    }

    public void fun2() {
        FatherClass f = new FatherClass();
        System.out.println(f instanceof FatherClass); //true
        System.out.println(f instanceof SonClass); //false
    }

    public void fun3() {
        SonClass f = new SonClass();
        System.out.println(f instanceof FatherClass); //true
        System.out.println(f instanceof SonClass); //true
    }

    public static void main(String[] args) {
        new PlymorphismTest01().fun1();
    }
}
