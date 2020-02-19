package variable_length_parameter;

/**
 * @author ：Gary Wu
 * @date ：Created in 11:13 2020/2/19
 * @description：可变长参数，打印出个数不定的列表中最大值的方法。
 * @version: $
 */

public class VarArgsDemo {

    public static void main(String[] args) {
        printMax(3, 28, 5, 17, 102);
        printMax(102, 32, 567, 8901, 12, 232, 42, 45, 634);
        printMax(new double[]{1, 3, 8, 4});
    }

    private static void printMax(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed.");
            return;
        }
        double result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > result) {
                result = numbers[i];
            }
        }
        System.out.println("最大的数为：" + result);
    }
}
