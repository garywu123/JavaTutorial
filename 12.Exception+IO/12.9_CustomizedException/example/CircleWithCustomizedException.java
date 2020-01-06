package example;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/06 13:33
 * @project JavaTutorial_2
 * @Description
 */
public class CircleWithCustomizedException {

    private double rad;
    private static int numberOfObjects;

    public CircleWithCustomizedException() throws InvalidRadiusException {
        this(1.0);
    }

    public CircleWithCustomizedException(double rad) throws InvalidRadiusException {
        setRadius(rad);
        numberOfObjects++;
    }

    private void setRadius(double newRad) throws InvalidRadiusException {

        if (newRad <= 0) {
            throw new InvalidRadiusException(newRad);
        }else
            rad = newRad;
    }

    public double calArea(double rad) {
        return rad * rad * Math.PI;
    }

    public double getRad() {
        return rad;
    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }
}
