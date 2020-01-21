import java.util.Arrays;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/18 20:37
 * @project JavaTutorial_2
 * @Description
 */
public class ComparableRectangle extends Rectangle
        implements Comparable<ComparableRectangle>{

    public static void main(String[] args) {
        ComparableRectangle[] rectangle1 = {
                new ComparableRectangle(10, 10),
                new ComparableRectangle(50, 20),
                new ComparableRectangle(10, 30),
                new ComparableRectangle(100, 210),
                new ComparableRectangle(10, 110)
        };

        Arrays.sort(rectangle1);
        for (ComparableRectangle rectangle : rectangle1) {
            System.out.println(rectangle);
        }
    }

    // 创建rectangle的构造器

    public ComparableRectangle(double width, double height) {
        super(width, height);
    }

    public int compareTo(ComparableRectangle object) {
        if (this.getArea() > object.getArea()) {
            return 1;
        }
        else if (getArea() < object.getArea()) {
            return -1;
        }else
            return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Area: " + getArea();
    }
}
