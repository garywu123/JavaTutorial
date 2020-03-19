package node_flow.fileinput_output_stream;

import java.io.*;
import java.util.ArrayList;

/**
 * @author ：Gary Wu
 * @date ：Created in 22:57 2020/2/27
 * @description：测试文件输出流
 * @version: $
 */

public class TestFileOutputStream {

    public static void main(String[] args) {
        int b = 0;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null ;

        try{
            File readFile = new File("Java_IO/test_folder/Test.txt");
            File writeFile = new File("Java_IO/test_folder/writeTest.txt");

            if (!writeFile.exists()) {
                boolean writeFileCreated = writeFile.createNewFile();
            }

            fileInputStream = new FileInputStream(readFile);
            fileOutputStream = new FileOutputStream(writeFile);
            byte[] temp = new byte[16];
            while (fileInputStream.read(temp) != -1) {
                fileOutputStream.write(temp);
            }
            fileOutputStream.flush();

            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
