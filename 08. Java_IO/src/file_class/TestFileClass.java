package file_class;

import java.io.File;

/**
 * @author: garyw
 * @since: 2020/2/24
 * @projectName: JavaTutorial_2
 * @description: 使用File类构建文件对象
 **/

public class TestFileClass {

    public static void main(String[] args) {

        // 显示当前JVM的路径
        String workingDir = System.getProperty("user.dir");
        System.out.println("你当前的工作目录为：" + workingDir);

        // 你也可以更改你的工作目录，仅针对Linux系统
//        workingDir = System.setProperty("user.dir",
//                           "C:\\Users\\garyw\\OneDrive\\Document\\Programming\\Java\\JavaTutorial_2\\temp");
//        System.out.println("你当前的工作目录为：" + workingDir);

        // 构建一个文件对象
        File file = new File("text.txt");

        // 判断文件是否存在
        if (!file.exists()) {
            System.out.println("File is not exist.");
        }else
            System.out.println("File is exist");

        // 提取文件的绝对路径和相对路径
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());

        // 判断是目录还是文件
        if (!file.isDirectory()) {
            System.out.println("指定目录为文件");
        }else
            System.out.println("指定目录为目录");

        System.out.println(file.exists());
    }
}
