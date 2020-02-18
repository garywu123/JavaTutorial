package collections_static_method;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author     ：Gary Wu
 * @date       ：Created in 13:38 2020/2/5 
 * @description：找出合集中的最大最小值
 * @modified By：
 * @version: $
 */

public class ListMaxAndMin {

    public static void main(String[] args) {
        List<String> stringsList1 = Arrays.asList("yellow", "blue", "red", "green");
        System.out.println(Collections.max(stringsList1));
        System.out.println(Collections.min(stringsList1));
    }
}
