package mergesort;

import com.sun.tools.javac.Main;

/**
 * @author ：Gary Wu
 * @date ：Created in 14:15 2020/2/19
 * @description：学习使用归并递归
 * @version: $
 */

public class MergeSort {

    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // 1. 先将数组对半分开
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // 2. 将第二个部分也进行分组
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // 将第一段和第二段合并
            merge(firstHalf, secondHalf, list);
        }
    }

    private static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0; // list1 中当前的索引
        int current2 = 0; // list2 中当前的索引
        int current3 = 0; // temp 中当前的索引

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            }else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }

        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }

    public static void main(String[] args) {
        int[] list = {2, 9, 5, 4, 8, 1, 6, 7, 3};
        mergeSort(list);
        for (int temp : list) {
            System.out.print(temp + ", ");
        }
    }
}
