package example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/07 10:30
 * @project JavaTutorial_2
 * @Description 程序清单12-16 文本替换器
 */
public class ReplaceText {
    public static void main(String[] args) throws FileNotFoundException {

        // 检查cmd的参数
        if (args.length != 4) {
            System.out.println("Usage: " +
                "Java ReplaceText sourceFile targetFile oldStr newStr");
            System.exit(1);
        }

        // 检查文件是否存在
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        // 检查目标文件是否存在
        File targetFile = new File(args[1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + args[1] + " already exists.");
            System.exit(3);
        }

        try (
            // 创建资源
            Scanner input = new Scanner(sourceFile);
            PrintWriter output = new PrintWriter(targetFile)
        ) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replace(args[2], args[3]);
                output.write(s2);
            }
        }
    }
}
