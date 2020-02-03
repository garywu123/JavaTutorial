package collection;

import java.util.ArrayList;

/**
 * @author     ：Gary Wu
 * @date       ：Created in 11:37 2020/2/3 
 * @description： 一个用来存放一组数据的类
 * @modified By：
 * @version: $
 */

public class StringCollection {

    private static ArrayList<String> collection1 = new ArrayList<>();

    public StringCollection() {
        collection1.add("New York");
        collection1.add("Atlanta");
        collection1.add("Dallas");
        collection1.add("Madison");
    }

    public static ArrayList<String> getCollection1() {
        return collection1;
    }

}
