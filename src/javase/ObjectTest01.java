package javase;

/**
 * clone() 方法使用后存在两个对象，地址不同
 */
public class ObjectTest01 implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectTest01 objectTest01 = new ObjectTest01();
        Object clone = objectTest01.clone();

        //因为 Object 的 equals 方法没有重写，所以比较的是两个 Object 是否为同一个地址的对象
        //clone() 方法使用后存在两个对象，地址不同
        System.out.println("-------------- 实验 1 --------------");
        System.out.println(objectTest01 == clone); //false
        System.out.println(objectTest01.equals(clone)); //false
        System.out.println(objectTest01); //javase.ObjectTest01@1b6d3586
        System.out.println(clone); //javase.ObjectTest01@4554617c
    }
}
