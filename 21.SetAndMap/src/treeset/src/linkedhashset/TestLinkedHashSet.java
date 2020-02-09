package treeset.src.linkedhashset;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ：Gary Wu
 * @date ：Created in 11:00 2020/2/9
 * @description：测试使用链表
 * @version: $
 */

public class TestLinkedHashSet {
    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("London");
        set1.add("New York");
        set1.add("Shanghai");
        set1.add("Beijing");
        set1.add("Wuhan");
        set1.add("London");

        System.out.println(set1);
    }
}
