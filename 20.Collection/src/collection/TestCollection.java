package collection;

import java.util.ArrayList;

/**
 * @author     ：Gary Wu
 * @date       ：Created in 11:28 2020/2/3 
 * @description：测试理解使用 集合
 * @modified By：
 * @version: $
 */

public class TestCollection {

    public static void main(String[] args) {
        ArrayList<String> collection1 = new ArrayList<>();
        collection1.add("New York");
        collection1.add("Atlanta");
        collection1.add("Dallas");
        collection1.add("Madison");

        System.out.println("一个包含城市名称的集合1");
        System.out.println(collection1);
    }
}
