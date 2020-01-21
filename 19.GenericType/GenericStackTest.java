import java.lang.reflect.GenericSignatureFormatError;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/20 17:17
 * @project JavaTutorial_2
 * @Description
 */
public class GenericStackTest {

    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>();
        stack1.push("London");
        stack1.push("Shanghai");
        stack1.push("New Bremen");
        System.out.println(stack1);

        GenericStack<Integer> stack2 = new GenericStack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        System.out.println(stack2);

    }
}
