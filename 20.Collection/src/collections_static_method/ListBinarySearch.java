package collections_static_method;/**
 * @author ：Gary Wu
 * @date ：Created in 22:09 2020/2/4
 * @description：
 * @modified By：
 * @version: $
 * @project: JavaTutorial_2
 */

import java.util.*;

/**
 * @author     ：Gary Wu
 * @date       ：Created in 22:09 2020/2/4 
 * @description： 线性表的搜索
 * @modified By：
 * @version: $
 */

public class ListBinarySearch {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(4, 6, 23, 45, 12, 32, 10, 66);
        Collections.sort(list1);
        System.out.println(list1);

        System.out.println("(1) Index： " + Collections.binarySearch(list1, 23));
        System.out.println("(2) Index： " + Collections.binarySearch(list1, 65));
    }
}
