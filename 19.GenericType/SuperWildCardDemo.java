/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/23 18:08
 * @project JavaTutorial_2
 * @Description
 */
public class SuperWildCardDemo {

    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>();
        GenericStack<Object> stack2 = new GenericStack<>();

        stack2.push("Java");
        stack2.push(2);
        stack1.push("Sun");

        add(stack1, stack2);
        AnyWildCardDemo.printStack(stack2);
    }

    public static <T> void add(GenericStack<T> stack1, GenericStack<? super T> stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
            // 传入stack2中的元素必须是T的父类
        }
    }
}
