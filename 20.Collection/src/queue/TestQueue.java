package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author     ：Gary Wu
 * @date       ：Created in 14:53 2020/2/5 
 * @description：一个使用队列储存字符串的例子
 * @modified By：
 * @version: $
 */

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Oklahoma");
        queue.offer("Indiana");
        queue.offer("Ohio");
        queue.offer("Georgia");
        queue.offer("Texas");

        while (queue.size() > 0) {
            System.out.println(queue.remove() + " ");
        }
    }
}
