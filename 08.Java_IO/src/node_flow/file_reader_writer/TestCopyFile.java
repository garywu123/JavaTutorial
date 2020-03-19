package node_flow.file_reader_writer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ：Gary Wu
 * @date ：Created in 22:52 2020/3/18
 * @description：利用Reader和Writer将文件内容相互复制
 * @version: $
 */

public class TestCopyFile {

    public static void main(String[] args) {
        File originalFile = new File("08.Java_IO/test_folder/Test.txt");
        File destFile = new File("08.Java_IO/test_folder/Test-Copy.txt");
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            if (!destFile.exists()) destFile.createNewFile();

            fileReader = new FileReader(originalFile);
            fileWriter = new FileWriter(destFile, true);

            char[] temp = new char[16];

            while (fileReader.read(temp) != -1) {
                fileWriter.write(temp);
                fileWriter.write("\n");
                fileWriter.flush();
            }

            fileReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
