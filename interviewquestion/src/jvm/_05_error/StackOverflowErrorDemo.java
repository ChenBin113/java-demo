package jvm._05_error;

public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
        //Exception in thread "main" java.lang.StackOverflowError
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}
