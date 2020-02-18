/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/23 17:11
 * @project JavaTutorial_2
 * @Description
 */
public class WildCardNeedDemo {

    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);

        System.out.println("最大数字为： " + max(intStack));

    }


    /**
     * 找出栈中最大的数字
     */
    public static double max(GenericStack<? extends Number> stack) {
        double max = stack.pop().doubleValue();

        while (!stack.isEmpty()) { // 只要栈不为空，就弹出一个数字
            double value = stack.pop().doubleValue();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
