package _07_blockingqueue;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
    }

}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return null;
    }
}