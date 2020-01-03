package _05_lock;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 锁住的方法，当前线程可以再进入其他 synchronized 修饰的方法
 * 其他线程需要等待锁归还
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        PhoneOne phoneOne = new PhoneOne();
        new Thread(phoneOne::sendSms, "A").start();
        new Thread(phoneOne::sendEmail, "B").start();
    }
}

class PhoneOne {
    public synchronized void sendSms() {
        System.out.println(Thread.currentThread().getName() + "in");
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("PhoneOne.sendSms");
        sendEmail();
        System.out.println(Thread.currentThread().getName() + "out");
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "in");
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("=========PhoneOne.sendEmail");
        System.out.println(Thread.currentThread().getName() + "out");
    }
}
