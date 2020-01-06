package execrise;

import example.CircleWithCustomizedException;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/06 13:32
 * @project JavaTutorial_2
 * @Description
 */
public class Test_12_26 {

    public static void main(String[] args) {
        try {
            method();
            System.out.println("After the method call");
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException in Main");
        } catch (Exception e) {
            System.out.println("Exception in main");
        }
    }

    static void method() throws Exception{
        try {
            CircleWithCustomizedException circle1 = new CircleWithCustomizedException(-2.0);
            System.out.println(circle1.getRad());
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException in method()");
        } catch (Exception ex) {
            System.out.println("Exception in method()");
            throw ex;
        }

    }
}
