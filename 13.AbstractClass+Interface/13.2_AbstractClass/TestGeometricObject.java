/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/08 23:35
 * @project JavaTutorial_2
 * @Description 程序清单13-4 为什么不在每个子类中创建getArea方法呢？
 */
public class TestGeometricObject {

    public static void main(String[] args) {

        GeometricObject geoObject1 = new Circle(5);
        GeometricObject geoObject2 = new Rectangle(5, 3);

        System.out.println("这两个对象会拥有相同的面积吗？ " + equalArea(geoObject1, geoObject2));

        displayGeometricObject(geoObject1);
        displayGeometricObject(geoObject2);

    }

    private static boolean equalArea(GeometricObject geoObject1, GeometricObject geoObject2) {
        return geoObject1.getArea() == geoObject2.getArea();
    }

    // 一个用来显示 几何图形 对象
    public static void displayGeometricObject(GeometricObject object) {
        System.out.println();
        System.out.println("The area is " + object.getArea());
        System.out.println("该图形的周长为 " + object.getPerimeter());
    }
}
