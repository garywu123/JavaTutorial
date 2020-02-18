package runnable;

/**
 * @author ：Gary Wu
 * @date ：Created in 14:50 2020/2/16
 * @description：
 * @version: $
 */
public class PrintNumber implements Runnable {

    @Override
    public void run() {
        Thread thread4 = new Thread(new PrintChar('c'));
        thread4.start();
        try {
            for (int i = 1; i <= 100; i++) {
                System.out.print(i + " ");
                if (i == 50) {
                    thread4.join();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
