package treeset.src.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @author     ：Gary Wu
 * @date       ：Created in 12:07 2020/2/7 
 * @description：学习如何使用HashSet
 * @modified By：
 * @version: $
 */


public class TestHashSet {

    public static void main(String[] args) {
        // 创建一个HashSet
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("New York");
        set.add("Shanghai");
        set.add("Beijing");
        set.add("Wuhan");
        set.add("Shanghai");

        System.out.println(set);

        for (String element : set) {
            System.out.println(element);
        }
    }
}