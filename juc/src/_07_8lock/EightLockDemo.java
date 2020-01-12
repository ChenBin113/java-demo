package _07_8lock;

import java.util.concurrent.TimeUnit;

/**
 * 1 标准访问，先打印短信还是邮件
 * 2 停2秒在短信方法内，先打印短信还是邮件
 * 3 普通的hello方法，是先打短信还是hello
 * 4 现在有两部手机，先打印短信还是邮件
 * 5 两个静态同步方法，1部手机，先打印短信还是邮件
 * 6 两个静态同步方法，2部手机，先打印短信还是邮件
 * 7 1个静态同步方法，1个普通同步方法，1部手机，先打印短信还是邮件
 * 邮件
 * 8 1个静态同步方法，1个普通同步方法，2部手机，先打印短信还是邮件
 * 邮件
 *
 * static Class 生产的工厂
 * synchronized this 对象，生产的产品
 */
public class EightLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            phone.sendSMS();
        }, "A").start();

        try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> {
            phone.sendEmail();
            //phone2.sendEmail();
        }, "B").start();

        //phone.hello();
    }
}

class Phone {
    public static synchronized void sendSMS() {
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("=============== send sms");
    }

    public synchronized void sendEmail() {
        System.out.println("send email");
    }

    public void hello() {
        System.out.println("************************ hello");
    }
}
