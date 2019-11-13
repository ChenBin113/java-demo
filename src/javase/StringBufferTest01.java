package javase;

/**
 * 1.StringBuffer 的扩容机制
 */
public class StringBufferTest01 {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer(); //初始化容量为 16
        buffer.append("Hello, this is "); //此时未超过 16 个字符，容量为 16
        buffer.append("my name!"); //此时超过 16 个字符，但不超过 16 * 2 + 2，扩容为 34
        buffer.append("H");
        buffer.append("H");
        buffer.append("Appends the specified StringBuffer to this sequence"); //此时超过 34 且超过 70 字符，扩容为等长容量 75
    }
}
