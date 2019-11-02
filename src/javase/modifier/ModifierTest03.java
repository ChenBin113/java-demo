package javase.modifier;

public class ModifierTest03 {
    public ModifierTest01 test01;

    public ModifierTest03(ModifierTest01 test01) {
        this.test01 = test01;
        System.out.println(test01.count);
    }
}
