package comparator;/**
 * @author ：Gary Wu
 * @date ：Created in 11:52 2020/2/4
 * @description：
 * @modified By：
 * @version: $
 * @project: JavaTutorial_2
 */

/**
 * @author ：Gary Wu
 * @date ：Created in 11:52 2020/2/4
 * @description：
 * @modified By：
 * @version: $
 */

public class TestComparator {

    public static void main(String[] args) {
        GeometricObject object1 = new Rectangle(300, 2);
        GeometricObject object2 = new Circle(5);

        GeometricObject g = max(object1, object2, new GeometricObjectComparator());
        System.out.println("面积更加大的对象是：" + g.getArea());

    }
    private static GeometricObject max(GeometricObject object1,
                                       GeometricObject object2,
                                       GeometricObjectComparator geometricObjectComparator) {
        if (geometricObjectComparator.compare(object1, object2) > 0) {
            return object1;
        }else
            return object2;

    }
}
