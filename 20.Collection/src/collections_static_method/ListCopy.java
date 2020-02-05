package collections_static_method;/**
 * @author ：Gary Wu
 * @date ：Created in 22:34 2020/2/4
 * @description：线性表的复制操作
 * @modified By：
 * @version: $
 * @project: JavaTutorial_2
 */

import java.util.*;

/**
 * @author ：Gary Wu
 * @date ：Created in 22:34 2020/2/4
 * @description：线性表的复制操作
 * @modified By：
 * @version: $
 */

public class ListCopy {
    public static void main(String[] args) {
        List<String> stringsList1 = Arrays.asList("yellow", "blue", "red", "green");
        List<String> stringsList2 = Arrays.asList("white", "black");

        Collections.copy(stringsList1, stringsList2);
        System.out.println(stringsList1);

        List<GregorianCalendar> emptyList =
                Collections.nCopies(5, new GregorianCalendar(2020, 1, 1));
        System.out.println(emptyList);

        // 线性表置换所有元素
        List<String> list = Arrays.asList("yellow", "blue", "red", "green");
        Collections.fill(list, "black");
        System.out.println(list);
    }
}
