package threadpool;

import runnable.PrintChar;
import runnable.PrintNumber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：Gary Wu
 * @date ：Created in 14:47 2020/2/16
 * @description：使用线程池来运行任务
 * @version: $
 */

public class ExecutorDemo {

    public static void main(String[] args) {
        // 创建一个只有三个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(new PrintChar('w'));
        executorService.execute(new PrintChar('g'));
        executorService.execute(new PrintNumber());

        executorService.shutdown();
    }
}
