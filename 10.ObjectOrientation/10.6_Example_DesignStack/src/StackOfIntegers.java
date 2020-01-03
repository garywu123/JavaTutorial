/**
 * @author ：Gary Wu
 * @date ：Created in 10:48 2020/1/3
 * @description：示例学习：设计栈类
 * @modified By：
 * @version: $
 * @project: JavaTutorial
 */

/**
 * @author     ：Gary Wu
 * @date       ：Created in 10:48 2020/1/3 
 * @description：示例学习：设计栈类
 * @modified By：
 * @version: $
 */

public class StackOfIntegers {

    private static final int DEFAULT_CAPACITY = 16;

    private int[] elements;
    private int size;

    /**
     * 默认构造器，创建一个大小为16的数组
     * */
    public StackOfIntegers() {
        elements = new int[DEFAULT_CAPACITY];
    }

    /**
     * @param capacity
     */
    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    /**
     * @return
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * @return
     */
    public int peek() {
        return elements[size - 1];
    }

    /**
     * @param value 需要添加的数
     */
    public void push(int value) {
        if (elements.length == 0) {
            elements[size] = value;
        }else{
            if (size >= elements.length) {
                int[] temp = new int[elements.length * 2];
                System.arraycopy(elements, 0, temp, 0, elements.length);
                elements = temp;
            }
            elements[size++] = value;
        }
    }

    /**
     * @return
     */
    public int pop() {
        return elements[--size];
    }

    /**
     * @return
     */
    public int getSize() {
        return size;
    }
}
