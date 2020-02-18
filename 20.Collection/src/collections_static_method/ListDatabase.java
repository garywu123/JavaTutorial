package collections_static_method;/**
 * @author ：Gary Wu
 * @date ：Created in 22:36 2020/2/4
 * @description：用来使用的List数据库，减少重复创建
 * @modified By：
 * @version: $
 * @project: JavaTutorial_2
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author ：Gary Wu
 * @date ：Created in 22:36 2020/2/4
 * @description：用来使用的List数据库，减少重复创建
 * @modified By：
 * @version: $
 */

public class ListDatabase {

    static List<Integer> integersList1 = Arrays.asList(4, 6, 23, 45, 12, 32, 10, 66);
    static List<String> stringsList1 = Arrays.asList("yellow", "blue", "red", "green");
    static List<String> stringsList2 = Arrays.asList("white", "black");
}
