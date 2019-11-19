package javase;

/**
 * 1.测试 / 和 % 的运算
 * 2./ 向 0 靠拢
 */
public class MathOperationTest01 {
    public static void main(String[] args) {
        System.out.println("-------------- 实验 1 --------------");
        System.out.println(-1 / 2); //0
        System.out.println(-1 / -2); //0
        System.out.println(1 / 2); //0

        System.out.println("-------------- 实验 2 --------------");
        System.out.println(-1 >> 2); //-1
        System.out.println(1 >> 2); //0

        //%，如果对负数取模，可以把模数负号忽略不计
        System.out.println("-------------- 实验 3 --------------");
        System.out.println(5 % -2); //1
        System.out.println(-5 % 2); //-1
        System.out.println(-5 % -2); //-1
        System.out.println(5 % 2); //1

        System.out.println("-------------- 实验 4 --------------");
        System.out.println(-3 / -2); //1
        System.out.println(-3 / 2); //-1
        System.out.println(3 / -2); //-1
    }
}
