package basic;

/**
 * 赋值运算符
 */
public class OperationTest02 {
    public static void main(String[] args) {
        /*
        计算机中以补码存在
        -1 原码是 1000 0001
           反码是 1111 1110
           补码是 1111 1111
        右移 >> 2 应该先移动 1 再移动 1
        最终结果仍然是 1111 1111
         */
        System.out.println("-------------- 实验 2 --------------");
        System.out.println(-1 >> 2); //-1
        System.out.println(1 >> 2); //0

        int i = 1;
        i *= 0.1;
        System.out.println(i); //0
    }
}
