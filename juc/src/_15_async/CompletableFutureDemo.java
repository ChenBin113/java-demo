package _15_async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("nothing");
        });
        voidCompletableFuture.get();

        //======================================
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return 1024;
        });
        System.out.println(integerCompletableFuture.get());

        //=======================================
        CompletableFuture<Integer> integerCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            //没有异常时，i 输出返回值，t 输出 null
            //int i = 10 / 0;
            return 1024;
        });
        integerCompletableFuture1.whenComplete((i, t) -> {
            System.out.println("****** i " + i);
            System.out.println("****** t " + t);
        }).exceptionally(f -> {
            System.out.println("****** f " + f.getMessage());
            return 404;
        }).get();
    }
}
