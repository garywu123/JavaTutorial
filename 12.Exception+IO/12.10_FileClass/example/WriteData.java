package example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/06 15:11
 * @project JavaTutorial_2
 * @Description 使用 Scanner 读取数据，然后使用 PrinterWriter 写入数据
 */
public class WriteData {

    public static void main(String[] args) throws FileNotFoundException {
        // 1. 首先为一个文本文件创建一个 printer 对象
        File file = new File("scores.txt");
        if (file.exists()) {
            System.out.println("File already exists.");
            System.exit(1);
        }

        PrintWriter output = new PrintWriter(file);

        // 2. 写入数据
        output.print("Jacques Zriah ");
        output.println("Christophe"); // 换行输入
        output.print("Gary Wu");
        output.print(1991);

        // 3. 关闭文件
        output.close();
    }
}
