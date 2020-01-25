package _02_jvm._05_error;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MetaspaceOOMTest {
    static class OOMTest {}

    public static void main(String[] args) {
        int i = 0;
        try {
            while (true) {
                i++;
                /*
                cglib 动态字节码技术创建类
                 */
                Enhancer enhancer  = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable throwable) {
            System.out.println("********** 多少次后发生异常 " + i);
            throwable.printStackTrace();
        }
    }
}
