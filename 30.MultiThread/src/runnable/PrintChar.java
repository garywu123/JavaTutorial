package runnable;

/**
 * @author ：Gary Wu
 * @date ：Created in 14:49 2020/2/16
 * @description：
 * @version: $
 */

public class PrintChar implements Runnable {
    char word;
    public PrintChar(char c) {
        word = c;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("Task " + word + " ");
        }
    }
}
