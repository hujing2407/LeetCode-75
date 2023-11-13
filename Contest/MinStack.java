import java.util.LinkedList;

/**
 * @author Jing Hu
 * @date Feb 12 2021
 */
class MinStack {

    LinkedList all;
    LinkedList min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        all = new LinkedList();
        min = new LinkedList();

    }

    public void push(int x) {
        all.add(x);
        if (min.isEmpty() || x <= getMin()) {
            min.add(x);
        }
    }

    public void pop() {
        int x = (int) all.remove(all.size() - 1);
        if (x == getMin()) {
            min.remove(min.size() - 1);
        }
    }

    public int top() {
        return (int) all.get(all.size() - 1);
    }

    public int getMin() {
        if (min.isEmpty()) {
            return -1;
        }
        return (int) min.get(min.size() - 1);
    }

    public int size() {
        return all.size();
    }
}