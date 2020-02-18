package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ：Gary Wu
 * @date ：Created in 17:39 2020/2/9
 * @description：创建一个映射表
 * @version: $
 */

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Gary", 28);
        hashMap.put("York", 33);
        hashMap.put("Anderson", 31);
        hashMap.put("Tom", 55);

        System.out.println("显示所有键值对");
        System.out.println(hashMap + "\n");

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("用来按照字幕顺序展示的TreeMap");
        System.out.println(treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Gary", 28);
        linkedHashMap.put("York", 33);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Tom", 55);

        System.out.println("\nThe age for " + " Gary is " + linkedHashMap.get("Gary"));
        System.out.println("打印整个LinkedHashMap中的键值对");
        System.out.println(linkedHashMap);
    }
}
