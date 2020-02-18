package comparator;/**
 * @author ：Gary Wu
 * @date ：Created in 11:48 2020/2/4
 * @description：利用 GeometricObject类，定义一个比较器
 * @modified By：
 * @version: $
 * @project: JavaTutorial_2
 */

import java.util.Comparator;

/**
 * @author ：Gary Wu
 * @date ：Created in 11:48 2020/2/4
 * @description：利用 GeometricObject类，定义一个比较器
 * @modified By：
 * @version: $
 */

// 对于比较器而言实现Serializable是一个好主意，可以用来序列化数据结构的排序方法
public class GeometricObjectComparator
        implements Comparator<GeometricObject>, java.io.Serializable {

    @Override
    public int compare(GeometricObject o1, GeometricObject o2) {
        double area1 = o1.getArea();
        double area2 = o2.getArea();

        if (area1 < area2) {
            return -1;
        }else if (area1==area2)
            return 0;
        else
            return 1;
    }
}
