import java.util.ArrayList;

/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/20 16:39
 * @project JavaTutorial_2
 * @Description
 */
public class GenericStack<E> {

    // 1. 定义一个数组列表用来储存元素
    private ArrayList<E> list = new ArrayList<>();

    public GenericStack() {
    }

    public int getSize(){
        return list.size();
    }

    public E peek(){
        return list.get(getSize() - 1);
    }

    public void push(E o) {
        list.add(o);
    }

    public E pop(){
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "GenericStack{" + "list=" + list.toString() + '}';
    }
}
