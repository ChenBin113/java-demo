package _14_forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
    public static void main(String[] args) {
        
    }
}

class MyTask extends RecursiveTask<Integer> {

    @Override
    protected Integer compute() {
        return 1024;
    }
}
