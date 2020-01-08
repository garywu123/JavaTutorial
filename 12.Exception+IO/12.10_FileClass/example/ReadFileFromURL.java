package example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/07 22:19
 * @project JavaTutorial_2
 * @Description
 */
public class ReadFileFromURL {

    public static void main(String[] args) {
        // 请求用户输入一个URL
        System.out.println("请输入需要获取数据的网站的URL");
        Scanner scanner = new Scanner(System.in);
        String urlString = scanner.nextLine();
        int count = 0; // 输入文件长度计算

        // 根据URL创建URL对象
        URL url = null;
        try {
            url = new URL(urlString);
            Scanner urlReader = new Scanner(url.openStream());

            while (urlReader.hasNext()) {
                String line = urlReader.nextLine();
                count += line.length();
            }

            System.out.println("File size is " + count + " characters.");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
