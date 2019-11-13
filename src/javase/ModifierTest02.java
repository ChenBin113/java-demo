package javase;

/**
 * 子类继承父类后
 * 在本包，上一级包，同级其他包三种方式
 * 都可以调用父类的 protected 属性
 */
public class ModifierTest02 extends ModifierTest01 {
    /*
    output:
    -------------- 实验 2 --------------
    -------------- 实验 1 --------------
    -------------- 实验 1 --------------3
    -------------- 实验 2 --------------3

    实验 super 调用，不能在 static 方法中；
    重温代码加载顺序：先执行打印语句；new ModifierTest02() 的时候才加载构造代码块；再回到 main 方法打印剩下的语句
     */
    public static void main(String[] args) {
        System.out.println("-------------- 实验 2 --------------");
        ModifierTest02 test02 = new ModifierTest02();
        System.out.println("-------------- 实验 2 --------------" + test02.height);
    }

    {
        System.out.println("-------------- 实验 1 --------------");
        System.out.println("-------------- 实验 1 --------------" + super.height);
    }
}
