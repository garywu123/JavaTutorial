package hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：Gary Wu
 * @date ：Created in 10:41 2020/2/9
 * @description：测试在Collection中的方法
 * @version: $
 */

public class TestMethodInCollection {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("London");
        set1.add("New York");
        set1.add("Shanghai");
        set1.add("Beijing");
        set1.add("Wuhan");

        System.out.println("Set1 is " + set1);
        System.out.println(set1.size() + " elements in set1");

        set1.remove("London");
        System.out.println("\nset1 is " + set1);
        System.out.println(set1.size() + " elements in set1");

        Set<String> set2 = new HashSet<>();
        set2.add("Paris");
        set2.add("Wuxi");
        set2.add("London");

        System.out.println("Set2 is " + set2);
        System.out.println("Set2 has " + set2.size() + " elements.");

        System.out.println("\nIs Taipei in Set2? " + set2.contains("Taipei"));

        set1.addAll(set2);
        System.out.println("\n将Set2中的元素添加到Set1中：" + set1);

        set1.removeAll(set2);
        System.out.println("\n将Set2的元素从Set1中移除后，set1：" + set1);

        set1.retainAll(set2);
        System.out.println("\n将set2与set1中非重复的元素移除后的set1：" + set1);
    }
}
