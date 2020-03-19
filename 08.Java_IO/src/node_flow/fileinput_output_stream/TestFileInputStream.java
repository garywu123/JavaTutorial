package node_flow.fileinput_output_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author ：Gary Wu
 * @date ：Created in 22:11 2020/2/27
 * @description：测试文件输入流
 * @version: $
 */

public class TestFileInputStream {

    public static void main(String[] args) {
        int b = 0;
        FileInputStream inputStream = null;

        try{
            inputStream = new FileInputStream("E:\\OneDrive\\Document\\Programming\\Java\\JavaTutorial_2\\Java_IO\\test_folder\\Test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("系统找不到指定文件");
            System.exit(-1);
        }

        try{
            long num = 0;
            while ((b = inputStream.read()) != -1) {
                System.out.println((char) b);
                num++;
            }
            inputStream.close();
            System.out.println();
            System.out.println("共读取了 " + num + " 个字节");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
