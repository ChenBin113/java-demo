package _01_volatile;

/**
 * 查看 i++ 的字节码是编译成为三条指令
 */
public class T1 {
    volatile int i = 1;
    public void addPlus() {
        i++;
    }
}
