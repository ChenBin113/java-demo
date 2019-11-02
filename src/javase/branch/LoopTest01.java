package javase.branch;

public class LoopTest01 {
    /*
    实验：for 和 while 循环
    验证：for 循环，变量可以从内存中较早的消失
    结果：循环结束时，i 变量仍存在，j 变量已消失，验证结论
    */
    public static void main(String[] args) {
        int i = 3;
        while (i > 0) {
            System.out.println(i--);
        }

        for (int j = 0; j < 3; j++) {
            System.out.println(j);
        }

        outer:
        for (int j = 0; j < 3; j++) {
            inner:
            for (int k = 0; k < 3; k++) {
                if (k == 2) {
                    break outer; //终结外循环
                    //break inner; //终结内循环，即不会打印 k = 2 的情况
                }
                System.out.println(k);
            }
        }
    }
}
