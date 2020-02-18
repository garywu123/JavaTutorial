/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/20 17:41
 * @project JavaTutorial_2
 * @Description
 */
public class GenericMethodTest {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};
        String[] countries = {"London", "Shanghai", "New Bremen", "Cincinnati", "Columbs"};
        GenericMethodDemo.print(integers);
        GenericMethodDemo.print(countries);
    }
}
