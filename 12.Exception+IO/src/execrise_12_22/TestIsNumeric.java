package execrise_12_22;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/06 0:01
 * @project JavaTutorial_2
 * @Description
 */
public class TestIsNumeric {

    public static void main(String[] args) {
        String testString1 = "1234jindf";
        String testString2 = "1234567";

        System.out.println(isNumeric(testString1));
        System.out.println(isNumeric(testString2));

    }

    private static boolean isNumeric(String string) {

        char[] charArray = string.toCharArray();

        for (char c : charArray) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
