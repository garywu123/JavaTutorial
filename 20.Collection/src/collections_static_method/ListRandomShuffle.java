package collections_static_method;/**
 * @author ：Gary Wu
 * @date ：Created in 22:28 2020/2/4
 * @description：对线性表进行随机排序
 * @modified By：
 * @version: $
 * @project: JavaTutorial_2
 */

import java.util.*;

/**
 * @author ：Gary Wu
 * @date ：Created in 22:28 2020/2/4
 * @description：对线性表进行随机排序
 * @modified By：
 * @version: $
 */

public class ListRandomShuffle {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("yellow", "blue", "red", "green");
        List<String> list2 = Arrays.asList("yellow", "blue", "red", "green");
        Collections.shuffle(list1, new Random(20));
        Collections.shuffle(list2, new Random(20));
        System.out.println(list1);
        System.out.println(list2);
    }
}
