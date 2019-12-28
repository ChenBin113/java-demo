package oom;

public class OutOfMemoryErrorTest01 {
    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10000; i++) {
                int[] array = new int[1024 * 1024];
            }
        }
    }
}
