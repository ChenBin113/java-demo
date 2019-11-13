package javase;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest01 {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(0, "东游记");// 直接存放叶子节点(Node)

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "西游记");
        map.put(2, "红楼梦");
        hashMap.putAll(map);
        System.out.println(hashMap);
    }
}
