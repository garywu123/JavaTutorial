package example;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/07 0:40
 * @project JavaTutorial_2
 * @Description 程序清单12-14 利用 try-with-resource 关闭资源
 */
public class WriteDataWithAutoClose {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("scores_2.txt");
        if (file.exists()) {
            System.out.println("文件已存在，程序退出");
            System.exit(0);
        }
        try (// 创建资源
            PrintWriter output = new PrintWriter(file);)
            {
                // 输出文件
                output.print("Gary");
                output.println(" 29 years old");
            }
    }
}
