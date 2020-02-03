package iterator;

import collection.StringCollection;

import java.util.Collection;
import java.util.Iterator;


/**
 * @author     ：Gary Wu
 * @date       ：Created in 11:36 2020/2/3 
 * @description：测试如何使用迭代器‘
 * @modified By：
 * @version: $
 */

public class TestIterator {
    public static void main(String[] args) {

        new StringCollection();
        Collection collection = StringCollection.getCollection1();
        System.out.println(collection);

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
