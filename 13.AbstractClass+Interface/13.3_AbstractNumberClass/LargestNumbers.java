import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/09 14:59
 * @project JavaTutorial_2
 * @Description
 */
public class LargestNumbers {

    public static void main(String[] args) {

        ArrayList<Number> numberList = new ArrayList<>();
        numberList.add(45);
        numberList.add(3445.53); // 添加一个 double 数字
        numberList.add(new BigInteger("35425730947509234609273417902374"));
        numberList.add(new BigDecimal("1123.223423587249034786902378461023461"));
        System.out.println("The largest number is: " + getLargestNumber(numberList));

    }

    private static Number getLargestNumber(ArrayList<Number> numberList) {
        if (numberList == null) {
            return null;
        }

        Number number = numberList.get(0); // 获取列表中的第一个数字
        for (int i = 1; i < numberList.size(); i++) {
            if (number.doubleValue() < numberList.get(i).doubleValue()) { //如果第一个数字比后面循环的小
                number = numberList.get(i); // number就等于后面那个较大的数字，继续循环
            }
        }
        return number;
    }
}
