package designpattern.proxy.dynamic;

public class Client {
    public static void main(String[] args) {
        ITeacherDao target = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        ITeacherDao proxyInstance = (ITeacherDao)proxyFactory.getProxyInstance();

        //System.out.println("代理对象" + proxyInstance);
        proxyInstance.sayHello("Tom");
    }
}
