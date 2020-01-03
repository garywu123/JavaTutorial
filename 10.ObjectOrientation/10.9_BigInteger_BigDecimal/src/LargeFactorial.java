/**
 * @author ：Gary Wu
 * @date ：Created in 12:10 2020/1/3
 * @description：
 * @modified By：
 * @version: $
 * @project: JavaTutorial
 */

import java.math.BigInteger;

/**
 * @author ：Gary Wu
 * @date ：Created in 12:10 2020/1/3
 * @description： 计算一个数的阶乘
 * @modified By：
 * @version: $
 */

public class LargeFactorial {

    public static void main(String[] args) {
        System.out.println(" 50! = " + factorial(50));
    }

    private static BigInteger factorial(int num) {

        BigInteger result = BigInteger.ONE;
        for (int i = 1; i < num; i++) {

            result = result.multiply(new BigInteger(i +""));
        }
        return result;
    }

}
