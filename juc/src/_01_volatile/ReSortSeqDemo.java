package _01_volatile;

/**
 * 指令重排演示 语句 1,2,3 的顺序没有固定的
 */
public class ReSortSeqDemo {
    int a = 0;
    boolean flag = false;

    public void method1() {
        a = 1;       //语句1
        flag = true; //语句2
    }

    /*
    多线程环境下线程交替执行，由于编译器优化重排的存在
    多线程使用的变量一致性不能保证，不能预测结果
     */
    public void method2() {
        if (flag) {
            a += 5;  //语句3
            System.out.println("a = " + a);
        }
    }
}
