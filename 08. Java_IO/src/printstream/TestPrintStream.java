package printstream;

import java.io.*;

/**
 * @author: garyw
 * @since: 2020/2/26
 * @projectName: JavaTutorial_2
 * @description: 测试如何使用PrintStream
 **/
/**
 * PrintStream是一个装饰流，在打印日志的同时将日志写入一个文件中
 * */
public class TestPrintStream {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\garyw\\OneDrive\\Document\\Programming\\Java\\02_JavaTutorial_2\\Java_IO\\test_folder\\test.txt");
        System.out.println(file.getPath());
        try{
            if (!file.exists())
                file.createNewFile();

            if (file.exists()) {
                PrintStream printStream = new PrintStream(file);
                printStream.println("test1");
                printStream.println("test2");
                printStream.println("test3");
                printStream.println("test4");
                printStream.print("+test5");

                printStream.flush();

                System.out.println("Text has been written to " + file.getAbsolutePath());
            }
            else {
                System.out.println("File not exist. Make sure you have created the file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
