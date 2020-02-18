import java.util.ArrayList;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/23 18:00
 * @project JavaTutorial_2
 * @Description
 */
public class AnyWildCardDemo {

    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);

        System.out.println("打印栈中的数字");
        printStack(intStack);

        ArrayList<String> list = new ArrayList<>();
        list.add("test");
        String state = list.get(0);
        System.out.println(state);


    }


    /**
     * 打印出栈中的数字
     */
    public static void printStack(GenericStack<?> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }


}


