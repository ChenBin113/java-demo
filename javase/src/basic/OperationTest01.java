package basic;

/**
 * 算术运算符
 * 1.测试 / 和 % 的运算
 * 2./ 向 0 靠拢
 */
public class OperationTest01 {
    public static void main(String[] args) {
        System.out.println("-------------- / 向 0 靠拢");
        System.out.println("-------------- 实验 --------------");
        System.out.println(-1 / 2); //0
        System.out.println(-1 / -2); //0
        System.out.println(1 / 2); //0

        System.out.println("-------------- 实验 --------------");
        System.out.println(-3 / -2); //1
        System.out.println(-3 / 2); //-1
        System.out.println(3 / -2); //-1

        //%，结果的符号和被模数相同
        System.out.println("-------------- %，结果的符号和被模数相同");
        System.out.println("-------------- 实验 --------------");
        System.out.println(5 % -2); //1
        System.out.println(-5 % 2); //-1
        System.out.println(-5 % -2); //-1
        System.out.println(5 % 2); //1


        System.out.println("-------------- 浮点数的除 0");
        System.out.println("-------------- 实验 --------------");
        System.out.println(1.0 / 0); //Infinity

        System.out.println("-------------- 自增运算符");
        System.out.println("-------------- 实验 --------------");
        byte b1 = 127;
        b1++;
        System.out.println(b1); //-128
    }
}
