package treeset;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author ：Gary Wu
 * @date ：Created in 14:22 2020/2/9
 * @description：测试使用比较器来创建一个TreeSet
 * @version: $
 */

public class TestTreeSetWithComparator {

    public static void main(String[] args) {
        Set<GeometricObject> set = new TreeSet<>(new GeometricObjectComparator());
        set.add(new Rectangle(4, 5));
        set.add(new Circle(4));
        set.add(new Circle(40));
        set.add(new Rectangle(4, 1));

        System.out.println("排序过后的图形序列");
        for (GeometricObject object : set) {
            System.out.println("面积为：" + object.getArea());
        }
    }
}
