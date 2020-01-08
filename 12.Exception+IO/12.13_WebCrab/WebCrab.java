import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/07 22:30
 * @project JavaTutorial_2
 * @Description 章节12.13 Web爬虫
 */

/*
 * 通过Web爬虫获取网页信息，具体算法如下：
 * */



public class WebCrab {

    public static void main(String[] args) {
        System.out.println("请输入URL");
        Scanner scanner = new Scanner(System.in);
        String urlString = scanner.nextLine();

        processURL(urlString);
    }

    private static void processURL(String urlString) {
        // 创建两个列表 用来区分URL是否被处理过
        List<String> urlPengdingList = new ArrayList<>();
        List<String> urlProcessedList = new ArrayList<>();
        urlPengdingList.add(urlString); // 将一个待处理的URL放入pending list中

        // 当 urlPendingList不为空，且处理过的URL小于100都时候，就开始循环
        while (!urlPengdingList.isEmpty() && urlProcessedList.size() <= 100) {
            // 将一个URL提取出来
            String urlToBeProcessed = urlPengdingList.remove(0);
            // 判断这个URL之前有没有处理过
            if (!urlProcessedList.contains(urlToBeProcessed)) {
                // 没有的话就放入处理名单中，因为要开始处理了
                urlProcessedList.add(urlToBeProcessed);
                System.out.println("开始爬取：" + urlToBeProcessed);

                // 循环获取 “待处理的URL” 中可以被视作为 “下一个待处理 URL“
                for (String s : getSubURLs(urlToBeProcessed)) { // 循环获取到内容
                    if (!urlProcessedList.contains(s)) { // 判断获取到的新网页是否之前处理过
                        urlPengdingList.add(s); // 没有处理过就添加到等待处理列表
                    }
                }
            }


        }
    }

    private static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>();

        URL url = null;
        try {
            url = new URL(urlString);
            Scanner scanner = new Scanner(url.openStream());

            int current = 0;
            while (scanner.hasNext()) { // 只要输入文本一直存在，就不断读取
                String line = scanner.nextLine(); // 获取下一行
                current = line.indexOf("http", current); // 获取当前位置

                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) {
                        // 确保寻找到了正确的URL
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    }
                    else
                        current = -1;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
