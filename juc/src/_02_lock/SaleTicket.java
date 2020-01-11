package _02_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 synchronized
 * 使用 lambda express
 */
public class SaleTicket {
    public static void main(String[] args) {
        //线程操作资源类
        Ticket ticket = new Ticket();

        //noLambdaExpress(ticket);

        lambdaExpress(ticket);
    }

    public static void lambdaExpress(Ticket ticket) {
        new Thread(() -> { for (int i = 0; i < 30; i++) ticket.saleTicketTwo();}, "A").start();
        new Thread(() -> { for (int i = 0; i < 30; i++) ticket.saleTicketTwo();}, "B").start();
        new Thread(() -> { for (int i = 0; i < 30; i++) ticket.saleTicketTwo();}, "C").start();
    }

    public static void noLambdaExpress(Ticket ticket) {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.saleTicket();
            }
        }, "A");

        Thread b = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.saleTicket();
            }
        }, "B");

        Thread c = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.saleTicket();
            }
        }, "C");

        a.start();
        b.start();
        c.start();
    }
}

class Ticket {
    //初始票
    private int number = 80;
    private ReentrantLock reentrantLock = new ReentrantLock();

    //线程安全
    //public synchronized void saleTicket() {
    //线程不安全
    public void saleTicket() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + " 线程 还有 " + (number--) + " 张票，剩下 " + number + " 张");
        }
    }

    public void saleTicketTwo() {
        reentrantLock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + " 线程 还有 " + (number--) + " 张票，剩下 " + number + " 张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
