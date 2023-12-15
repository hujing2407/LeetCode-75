package Medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jing Hu
 * @date Feb 12 2021
 */
class MinStack {

    Deque<Integer> stack = null;
    Deque<Integer> minstack = null;

    public MinStack() {
        stack = new LinkedList<>();
        minstack = new LinkedList<>();
        minstack.offer(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.offerLast(val);
        if(minstack.peekLast() > val) minstack.offerLast(val);
        else minstack.offerLast(minstack.peekLast());
    }

    public void pop() {
        stack.removeLast();
        minstack.removeLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return minstack.peekLast();
    }

    public static void main(String[] args) {
        /**
         * Your MinStack object will be instantiated and called as such: */
          MinStack obj = new MinStack();
          obj.push(-2);
          obj.push(0);
          obj.push(-3);
        int param_4 = obj.getMin();
        obj.pop();
        obj.pop();
        int param_3 = obj.getMin();

    }
}