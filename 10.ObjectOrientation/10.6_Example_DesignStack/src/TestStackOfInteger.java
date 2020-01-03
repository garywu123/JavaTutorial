/**
 * @author ：Gary Wu
 * @date ：Created in 11:03 2020/1/3
 * @description：程序清单10-7 测试栈类
 * @modified By：
 * @version: $
 * @project: JavaTutorial
 */

/**
 * @author ：Gary Wu
 * @date ：Created in 11:03 2020/1/3
 * @description：程序清单10-7 测试栈类
 * @modified By：
 * @version: $
 */

public class TestStackOfInteger {

    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers(100);

        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + ", ");
        }
    }
}
