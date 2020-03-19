package node_flow.file_reader_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ：Gary Wu
 * @date ：Created in 22:37 2020/3/18
 * @description：测试文件写入流
 * @version: $
 */

public class TestFileWriter {

    public static void main(String[] args) {

        File file = new File("08.Java_IO/test_folder/Test.txt");
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file);

            for (int i = 0; i < 50000; i++) {
                fileWriter.write(i); //将整数转为字符写入，所以你打开Test文本以后发现包含了各种字符
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
