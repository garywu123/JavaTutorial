package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author ：Gary Wu
 * @date ：Created in 17:06 2020/2/3
 * @description：测试使用线性表和链表
 * @modified By：
 * @version: $
 * @project: JavaTutorial_2
 */


public class TestArrayAndLinkedList {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(0, 10);
        arrayList.add(3, 30);

        System.out.println("打印出一个全部是整数的列表");
        System.out.println(arrayList);

        LinkedList<Object> linkedList = new LinkedList<>(arrayList);
        linkedList.add(1, "Red");
        linkedList.removeLast();
        linkedList.addFirst("green");

        System.out.println("打印创建的链表");
        ListIterator<Object> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        System.out.println();

        System.out.println("反向打印创建的链表");
        listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
