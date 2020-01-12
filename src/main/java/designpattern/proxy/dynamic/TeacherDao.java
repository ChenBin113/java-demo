package designpattern.proxy.dynamic;

public class TeacherDao implements ITeacherDao {
    @Override
    public void sayHello(String name) {
        System.out.println("————" + name + "————");
    }
}
