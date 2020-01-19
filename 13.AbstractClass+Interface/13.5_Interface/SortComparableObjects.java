import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/18 20:28
 * @project JavaTutorial_2
 * @Description
 */
public class SortComparableObjects {

    public static void main(String[] args) {
        String[] cities = {"Savannah", "Boston", "Atlanta", "Tampa"};
        Arrays.sort(cities); // String 对象实现了 Comparable接口因此可以使用sort方法
        for (String city : cities) {
            System.out.println(city + " ");
        }
        System.out.println();

        BigInteger[] hugeNums = {
                new BigInteger("2749852034967239469"),
                new BigInteger("78974395279843752983"),
                new BigInteger("475892739804370"),
        };
        Arrays.sort(hugeNums);
        for (BigInteger number: hugeNums)
            System.out.println(number + " ");
    }
}
