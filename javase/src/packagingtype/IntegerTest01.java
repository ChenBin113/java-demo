package packagingtype;

/**
 * 1.测试 Integer 类的方法 highestOneBit
 */
public class IntegerTest01 {
    public static void main(String[] args) {
        System.out.println("-------------- 实验 1 --------------");
        for (int i = 0; i < 10; i++) {
            System.out.print(Integer.highestOneBit(i) + "   "); //output: 0   1   2   2   4   4   4   4   8   8
        }
        System.out.println();

        //1. new 是开辟了新空间存储
        //2. Integer 用 equals 比较值，== 比较的是地址值和值，即是否为同一对象
        //3. 方法区中有整型常量池，存有 -128 ~ 127 的值，可直接引用，i3 i4 指向的是同一个地方的值，i5 i6 则是两个不同的地方，和 new 的效果一样
        System.out.println("-------------- 实验 2 --------------");
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1.equals(i2)); //true
        System.out.println(i1 == i2); //false

        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i3 == i4); //true

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6); //false

        // >> 除 2，向下取整
        // << 乘 2
        // >>> 无符号右移 右推，左补 0
        System.out.println("-------------- 实验 3 --------------");
        System.out.println(3 >> 1); //1
        System.out.println(3 << 1); //6
        System.out.println(3 >>> 1); //1

        System.out.println("-------------- 实验 4 --------------");
        System.out.println(-3 >> 1); //-2
        System.out.println(-3 << 1); //-6
        System.out.println(-3 >>> 1); //2147483646
        //11111111111111111111111111111101 -3
        //01111111111111111111111111111110 2147483646
    }
}
