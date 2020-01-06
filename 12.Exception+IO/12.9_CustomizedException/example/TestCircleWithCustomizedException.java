package example;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/06 13:13
 * @project JavaTutorial_2
 * @Description
 */
public class TestCircleWithCustomizedException {

    public static void main(String[] args) {

        try {
            CircleWithCustomizedException circle1 = new CircleWithCustomizedException(2.0);
            CircleWithCustomizedException circle2 = new CircleWithCustomizedException(8.0);
            CircleWithCustomizedException circle3 = new CircleWithCustomizedException(-1.0);
        } catch (InvalidRadiusException e) {
            e.printStackTrace();
        }finally {
            System.out.println(CircleWithCustomizedException.getNumberOfObjects());
        }

    }
}

