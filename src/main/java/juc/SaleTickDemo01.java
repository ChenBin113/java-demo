package juc;


/**
 * 题目：三个售票员，卖出，30 张票
 * 笔记：如何编写企业级的多线程代码
 * <p>
 * 1.在高内聚低耦合的前提下，线程 操作 资源类
 * 1.1 先创建一个资源类
 */
public class SaleTickDemo01 {

    public static void main(String[] args) {
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        Thread thread3 = new Thread();

        Ticket ticket = new Ticket();

        thread1.start();
        thread2.start();
        thread3.start();

        //TODO 打个断点，明天继续写
    }

}

class Ticket {
    private int number = 30;

    public synchronized void sale() {
        synchronized (this) {
            number--;
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {

    }
}


