package forkjoin;

import java.sql.ResultSet;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author ：Gary Wu
 * @date ：Created in 16:22 2020/2/19
 * @description：利用并行方法，查找线性表中最大的数
 * @version: $
 */

public class ParallelMax {

    public static void main(String[] args) {
        final int N = 9000000;
        int[] list = new int[N];

        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        long startTime = System.currentTimeMillis();
        System.out.println("\nThe maximal number is " + max(list));
        long endTime = System.currentTimeMillis();
        System.out.println("\n多线程异步合并排序算法所用时间为 " +
                       Runtime.getRuntime().availableProcessors()+
                       " processors is " + (endTime - startTime) + " 毫秒");
    }

    public static int max(int[] list) {
        RecursiveTask<Integer> task = new MaxTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    private static class MaxTask extends RecursiveTask<Integer> {
        private final static int THRESHOLD = 1000;
        private int[] list;
        private int low;
        private int high;

        public MaxTask(int[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        protected Integer compute() {
            if (high - low < THRESHOLD) {
                int max = list[0];
                for (int i = low; i < high; i++) {
                    if (list[i] > max) {
                        max = list[i];
                    }
                }
                return new Integer(max);
            }else {
                int mid = (low + high) / 2;
                RecursiveTask<Integer> left = new MaxTask(list, low, mid);
                RecursiveTask<Integer> right = new MaxTask(list, mid, high);

                right.fork();
                left.fork();
                return Math.max(left.join(), right.join());
            }
        }
    }

}
