package file_class;

import java.io.File;
import java.io.IOException;

/**
 * @author: garyw
 * @since: 2020/2/24
 * @projectName: JavaTutorial_2
 * @description: 通过利用File类来测试创建文件、文件夹、删除、重命名等操作
 **/

public class TestCreateFiles {

    public static final String TEST_PATH = "C:\\Users\\garyw\\OneDrive\\Document\\Programming\\Java\\JavaTutorial_2\\temp";

    public static void main(String[] args) {

        File file = new File(TEST_PATH, "test.txt");
        if (!file.exists()) {
            System.out.println("文件不存在，创建文件");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
