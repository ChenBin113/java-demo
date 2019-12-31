import java.util.Scanner;

/**
 * 测试 Scanner do-while switch-case
 */
public class ScannerTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        do {
            System.out.println(i);
            i--;
        } while (i > 0);

        String s = scanner.next();
        switch (s) {
            case "Spring":
                System.out.println("春天");
                break;
            case "Summer":
                System.out.println("夏天");
                break;
            case "Autumn":
                System.out.println("秋天");
                break;
            case "Winter":
                System.out.println("冬天");
                break;
            default:
                System.out.println("非四季");
        }

        int month = scanner.nextInt();
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("春天");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏天");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋天");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬天");
                break;
            default:
                System.out.println("非四季");
        }
    }
}
