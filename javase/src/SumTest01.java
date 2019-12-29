public class SumTest01 {
    public static int sum(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i-- + sum(i);
        }
    }

    public static void main(String[] args) {
        int sum = sum(3);
        System.out.println(sum);

        int i = 5;
        System.out.println(i-- + i);
    }
}
