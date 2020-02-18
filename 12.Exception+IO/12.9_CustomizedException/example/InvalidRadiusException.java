package example;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/06 13:09
 * @project JavaTutorial_2
 * @Description
 */
public class InvalidRadiusException extends Exception {

    private double radius;

    public InvalidRadiusException(double radius) {
        super("Invalid Radius"+radius);
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }
}
