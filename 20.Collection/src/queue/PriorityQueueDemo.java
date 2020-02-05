package queue;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author ：Gary Wu
 * @date ：Created in 16:16 2020/2/5
 * @description：优先队列
 * @modified By：
 * @version: $
 */

public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        queue1.offer("Oklahoma");
        queue1.offer("Indiana");
        queue1.offer("Georgia");
        queue1.offer("Texas");

        System.out.println("通过使用元素内部的Comparable进行排序");
        while (queue1.size() > 0) {
            System.out.println(queue1.remove() + " ");
        }

        PriorityQueue<String> queue2 = new PriorityQueue<>(4, Collections.reverseOrder());
        queue2.offer("Oklahoma");
        queue2.offer("Indiana");
        queue2.offer("Georgia");
        queue2.offer("Texas");

        System.out.println("\nPriority queue using Comparator");
        while (queue2.size() > 0) {
            System.out.println(queue2.remove() + " ");
        }
    }
}
