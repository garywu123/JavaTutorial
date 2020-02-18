package runnable;

/**
 * @author ：Gary Wu
 * @date ：Created in 11:18 2020/2/10
 * @description：创建三个打印任务来共享CPU
 * @version: $
 */

public class TaskThreadDemo {

    public static void main(String[] args) {
        PrintChar printCharA = new PrintChar('A');
        PrintChar printCharB = new PrintChar('B');
        PrintNumber printNumber = new PrintNumber();

        Thread threadA = new Thread(printCharA);
        Thread threadB = new Thread(printCharB);
        Thread threadC = new Thread(printNumber);
        threadC.setPriority(Thread.MAX_PRIORITY);

        threadA.start();
        threadB.start();
        threadC.start();
    }
}



