package node_flow.file_reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ：Gary Wu
 * @date ：Created in 22:02 2020/3/18
 * @description：测试FileReader类
 * @version: $
 */

public class TestFileReader {

    public static void main(String[] args) {
        File readFile = new File("08.Java_IO/test_folder/Test.txt");

        try (FileReader fileReader = new FileReader(readFile)){
            char[] temp = new char[16];
            while (fileReader.read(temp) != -1) {
                for (char c : temp) {
                    System.out.print(c);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件无法读取");
            e.printStackTrace();
        }
    }
}
