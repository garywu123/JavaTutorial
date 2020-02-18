/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/20 17:34
 * @project JavaTutorial_2
 * @Description
 */
public class GenericMethodDemo {

    public static <E> void print(E[] list) {
        for (E o : list) {
            System.out.println(o);
        }
    }
}

