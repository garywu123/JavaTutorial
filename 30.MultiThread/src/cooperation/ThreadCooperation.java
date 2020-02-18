package cooperation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：Gary Wu
 * @date ：Created in 9:59 2020/2/17
 * @description：提款与存款线程交互
 * @version: $
 */

public class ThreadCooperation {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new DepositTask());
        executorService.execute(new WithdrawTask());
        executorService.shutdown();

        System.out.println("Thread l\t\t Thread 2\t\tBalance");
    }

    public static class DepositTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    account.deposit((int) (Math.random() * 10) + 1);
                    Thread.sleep(10);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static class WithdrawTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                account.withdraw((int) (Math.random() * 10) + 1);
            }
        }
    }

    private static class Account{
        private static Lock lock = new ReentrantLock();

        private static Condition newDeposit = lock.newCondition();

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            lock.lock();
            try {
                while (balance < amount) {
                    System.out.println("\t\t\tWait for a deposit");
                    newDeposit.await();
                }
                /*
                * while是正确的，if是错误的。
                * while会持续判断余额与提款额，只有当满足条件后才会执行
                * 但是if会在判断一次以后，依旧继续往下执行
                * */
                /*if (balance < amount) {
                    System.out.println("\t\t\tWait for a deposit");
                    newDeposit.await();
                }*/
                balance -= amount;
                System.out.println("\t\t\tWithdraw " + amount +
                                           "\t\t\t\t" + getBalance());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void deposit(int amount) {
            lock.lock();
            try{
                balance += amount;
                System.out.println("Deposit " + amount + "\t\t\t\t\t\t\t" + getBalance());

                newDeposit.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }
}
