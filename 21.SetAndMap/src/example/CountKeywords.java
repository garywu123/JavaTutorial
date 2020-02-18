package example;

import java.io.File;
import java.util.*;

/**
 * @author ：Gary Wu
 * @date ：Created in 15:58 2020/2/9
 * @description：测试Java源文件中的关键字出现次数
 * @version: $
 */

public class CountKeywords {
    public static void main(String[] args) throws Exception {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入一个Java源文件目录");
            String fileName = scanner.nextLine();

            File file = new File(fileName);
            if (file.exists()) {
                System.out.println("The number of Keywords in " +
                                           fileName + " is " + countKeywords(file));
            }else
                System.out.println("File " + fileName + " is not exist.");
        }
    }

    private static int countKeywords(File file) throws Exception {

        String[] keywords = {"abstract", "assert", "boolean", "break", "byte",
                "case", "catch", "char", "class", "const", "continue", "default",
                "do", "double", "else", "enum", "extends", "false", "final", "finally",
                "float", "for", "goto", "if", "implements", "import", "instanceof",
                "int", "interface", "long", "native", "new", "null", "package",
                "private", "protected", "public", "return", "short", "static", "strictfp",
                "super", "switch", "synchronized", "this", "throw", "throws",
                "transient", "try", "true", "void", "volatile", "while"};

        Set<String> keywordsSet = new HashSet<>(Arrays.asList(keywords));
        int count = 0;

        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String word = input.next();
            if (keywordsSet.contains(word)) {
                count++;
            }
        }
        return count;
    }
}
