/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/20 21:50
 * @project JavaTutorial_2
 * @Description
 */
public class GenericSort {
    public static void main(String[] args) {
        Integer[] intArray = {2, 4, 3, 1, 7, 9, 8};
        sort(intArray);
        printList(intArray);

        Double[] doubleArray = {2.3, 4.7, 1.4, 3.6, 5.8};
        sort(doubleArray);
        printList(doubleArray);

        Character[] charArray = {'a', 'd', 'f', 'b', 'c'};
        sort(charArray);
        printList(charArray);

    }

    public static <E extends Comparable<E>> void sort(E[] list) {
        E currentMin;
        int currentMinIndex;
        // 冒泡排序
        for (int i = 0; i < list.length - 1; i++) {
            // 1. 假设第一个是最小的
            currentMin = list[i];
            currentMinIndex = i;
            for (int j = i+1; j < list.length - 1; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void printList(Object[] list) {
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
