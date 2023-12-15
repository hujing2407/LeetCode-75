package Medium;

/**
 * @author Jing Hu
 * @date Dec. 14 2023
 */
public class MyCircularDeque {
    int[] deque = null;
    int head, tail, size;

    public MyCircularDeque(int k) {
        this.deque = new int[k];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public boolean insertFront(int value) {
        if (size == deque.length) return false;
        head = (--head + deque.length) % deque.length;
        deque[head] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == deque.length) return false;
        deque[tail] = value;
        tail = ++tail % deque.length;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) return false;
        head = ++head % deque.length;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) return false;
        tail = (--tail + deque.length) % deque.length;
        size--;
        return true;
    }

    public int getFront() {
        if(size == 0) return -1;
        return deque[head];
    }

    public int getRear() {
        if(size == 0) return -1;
        return deque[(tail-1+deque.length)%deque.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == deque.length;
    }

    public static void main(String[] args) {
        MyCircularDeque m = new MyCircularDeque(3);
        m.insertFront(9);
        m.getRear();
        m.insertFront(9);
        m.getRear();
        m.insertLast(5);
        m.getFront();
        m.getRear();
        m.getFront();
        m.insertLast(8);
        m.deleteLast();
        m.getFront();


    }
}
