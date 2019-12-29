public class Main {
    public static void main(String[] args) {
        System.out.println("-------------- 实验 1 --------------");
        char c = '\u2000';//Unicdoe空白字符
        String str = c + "abc" + c;
        System.out.println();
        System.out.println(str.trim());
    }
}
