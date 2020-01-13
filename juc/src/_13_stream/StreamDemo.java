package _13_stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 偶数 ID
 * 年龄大于 24
 * 用户名转为大写
 * 用户名倒排序
 * 只输出一个用户名字
 */
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        list.stream().filter(user -> {
            return user.getId() % 2 == 0;
        }).filter(user -> {
            return user.getAge() > 24;
        }).map(user -> {
            return user.getUserName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(1).forEach(user -> {
            System.out.println(user);
        });

        /*List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = list1.stream().map(number -> {
            return number * 3;
        }).collect(Collectors.toList());

        for (Integer integer : list2) {
            System.out.println(integer);
        }*/
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private int id;
    private String userName;
    private int age;
}
