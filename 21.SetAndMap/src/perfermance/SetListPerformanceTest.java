package perfermance;

import java.util.*;

/**
 * @author ：Gary Wu
 * @date ：Created in 15:16 2020/2/9
 * @description：对比集合Set和线性表List之间的性能差距
 * @version: $
 */

public class SetListPerformanceTest {

    static final int N = 10000;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        Collection<Integer> set1 = new HashSet<>(list);
        System.out.println("创建HashSet所用时间：" +
                                   getTestTime(set1) + " 毫秒");
        System.out.println("移除HashSet中所有元素所需时间：" +
                                   getRemoveTime(set1) + " 毫秒");

        Collection<Integer> set2 = new LinkedHashSet<>(list);
        System.out.println("创建LinkedHashSet所用时间：" +
                                   getTestTime(set2) + " 毫秒");
        System.out.println("移除LinkedHashSet中所有元素所需时间：" +
                                   getRemoveTime(set2) + " 毫秒");

        Collection<Integer> set3 = new TreeSet<>(list);
        System.out.println("创建TreeSet所用时间：" +
                                   getTestTime(set3) + " 毫秒");
        System.out.println("移除TreeSet中所有元素所需时间：" +
                                   getRemoveTime(set3) + " 毫秒");

        Collection<Integer> list1 = new ArrayList<>(list);
        System.out.println("创建ArrayList所用时间：" +
                                   getTestTime(list1) + " 毫秒");
        System.out.println("移除ArrayList中所有元素所需时间：" +
                                   getRemoveTime(list1) + " 毫秒");

        Collection<Integer> list2 = new LinkedList<>(list);
        System.out.println("创建LinkedList所用时间：" +
                                   getTestTime(list2) + " 毫秒");
        System.out.println("移除LinkedList中所有元素所需时间：" +
                                   getRemoveTime(list2) + " 毫秒");
    }

    private static long getRemoveTime(Collection<Integer> collection) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            collection.remove(i);
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long getTestTime(Collection<Integer> collection) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            collection.contains((int) (Math.random() * 2 * N));
        }
        return System.currentTimeMillis() - startTime;
    }
}
