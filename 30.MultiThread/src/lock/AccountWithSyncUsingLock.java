package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：Gary Wu
 * @date ：Created in 15:19 2020/2/16
 * @description：
 * @version: $
 */

public class AccountWithSyncUsingLock {

    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 创建100个线程
        for (int i = 0; i < 100; i++) {
            executorService.execute(new AddAPennyTask());
        }
        executorService.shutdown();

        // 等待直到所有线程终结
        while (!executorService.isTerminated()) {
        }

        System.out.println("账户余额？ -- " + account.getBalance());

    }

    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }
    }

    private static class Account{
        // 我们也可以通过给对象手动加锁
        private static Lock lock = new ReentrantLock();
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount){

            int newBalance = balance + amount;
            // 这个延迟能够让线程冲突的问题更加明显
            // 相当于前面一个线程加了1,然后开始休眠但是后面的线程已经开始执行了
            // 并且读取到的数据还是1，因为前一个线程并未更新数据
            try {
                Thread.sleep(5);
                balance = newBalance;
            } catch (InterruptedException e) {
            }finally {
                lock.unlock(); // 解锁
            }
        }
    }
}

