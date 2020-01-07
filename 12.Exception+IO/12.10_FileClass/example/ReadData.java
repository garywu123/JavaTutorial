package example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/07 0:56
 * @project JavaTutorial_2
 * @Description
 */
public class ReadData {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("scores.txt");
        readFile(file);

        /*while (scanner.hasNext()) {
            String firstName = scanner.next();
            String middleName = scanner.next();
            String lastName = scanner.next();
            int score = scanner.nextInt();
            System.out.println(firstName + " " + middleName + " " + lastName + " score " + score);
        }
        scanner.close();*/
    }

    public static void readFile(File file) throws FileNotFoundException {
        try (Scanner inputScanner = new Scanner(file)) {
            while (inputScanner.hasNext()) {
                int intValue = inputScanner.nextInt();
                String line = inputScanner.nextLine(); // nextLine 是以行分隔符结束的
                System.out.println(intValue + "||" + line);
            }
        }
    }
}
