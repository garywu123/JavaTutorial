package treeset.src.treeset;

import java.util.TreeSet;

/**
 * @author ：Gary Wu
 * @date ：Created in 12:05 2020/2/9
 * @description：按照字幕顺序来对set进行排列
 * @version: $
 */

public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<String> set1 = new TreeSet<>();
        set1.add("London");
        set1.add("New York");
        set1.add("Shanghai");
        set1.add("Beijing");
        set1.add("Wuhan");

        System.out.println("排序过后的集合：" + set1);

        // 使用方法来返回set中的各个顺序元素
        System.out.println("first(): " + set1.first());
        System.out.println("last(): " + set1.last());
        System.out.println("headSet(\"New York\"): " + set1.headSet("New York"));
        System.out.println("tailSet(\"Shanghai\"): " + set1.tailSet("Shanghai"));

        // 使用NavigableSet中的方法
        System.out.println("lower(\"P\"): " + set1.lower("P"));
        System.out.println("higher(\"P\"): " + set1.higher("P"));
        System.out.println("floor(\"P\"): " + set1.floor("P"));
        System.out.println("celling(\"P\"): " + set1.ceiling("P"));
        System.out.println("pollFirst(): " + set1.pollFirst());
        System.out.println("pollLast(): " + set1.pollLast());
        System.out.println("New tree set: " + set1);
    }
}
