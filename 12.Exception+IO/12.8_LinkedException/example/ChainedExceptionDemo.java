package example;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/06 0:43
 * @project JavaTutorial_2
 * @Description
 */
public class ChainedExceptionDemo {

    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void method1() throws Exception {
        try {
            method2();
        } catch (Exception ex) {
            throw new Exception("New info from method1");
        }
    }

    private static void method2() throws Exception {
        throw new Exception("New info from method2");
    }
}
