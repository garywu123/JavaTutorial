import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/07 21:59
 * @project JavaTutorial_2
 * @Description
 */
public class Temp {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }




}
