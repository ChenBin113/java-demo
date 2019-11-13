package javase;

import java.util.Calendar;

/**
 * 1.测试 Calendar 类使用的 简单工厂模式
 */
public class CalendarTest01 {
    public static void main(String[] args) {
        //Calendar 里用了很多 double check
        Calendar instance = Calendar.getInstance();
    }
}
