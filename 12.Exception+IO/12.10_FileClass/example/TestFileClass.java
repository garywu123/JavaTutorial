package example;

import java.io.File;
import java.util.Date;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/06 13:51
 * @project JavaTutorial_2
 * @Description
 */
public class TestFileClass {
    public static void main(String[] args) {
        // 1. 创建一个文件对象，但不等于创建一个文件
        File file = new File("image/us.gif");
        // 2. 创建一个以当前目录的文件夹
        File directory = new File("");
        System.out.println(directory.getAbsolutePath());

        System.out.println("Does it exist? " + file.exists());
        System.out.println("The file has " + file.length() + " bytes");
        System.out.println("Can it be read? " + file.canRead());
        System.out.println("Can it be written? " + file.canWrite());
        System.out.println("Is it directory? " + file.isDirectory());
        System.out.println("Is it a file? " + file.isFile());
        System.out.println("Is it absolute? " + file.isAbsolute());
        System.out.println("Is it hidden? " + file.isHidden());
        System.out.println("Absolute path is " + file.getAbsolutePath());
        System.out.println("Last modified on " + new Date(file.lastModified()));
    }
}
