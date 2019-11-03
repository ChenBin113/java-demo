package javase.modifier;

public class ModifierTest02 extends ModifierTest01 {
    /*
    output:
    -------------- 实验 2 --------------
    -------------- 实验 1 --------------
    -------------- 实验 1 --------------3
    -------------- 实验 2 --------------3

    实验 super 调用，不能在 static 方法中；
    重温代码加载顺序
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
