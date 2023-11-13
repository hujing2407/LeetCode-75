package FancySequence;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Jing Hu
 * @date Jan 30 2021
 */
class Fancy {

    ArrayList<Long> fancy = new ArrayList<>();
    ArrayList<Long> curList = new ArrayList<>();
    ArrayList<Long> multiList = new ArrayList<>();

    private static final long MODULO = 1000000007;

    public Fancy() {

    }

    public void append(int val) {
        fancy.add(Long.valueOf(val));
    }

    public void addAll(int inc) {
        for (int i = 0; i < fancy.size(); i++) {
            fancy.set(i, fancy.get(i) + inc);
        }
    }

    public void multAll(int m) {
        for (int i = 0; i < fancy.size(); i++) {
            fancy.set(i, fancy.get(i) * m);
        }
    }

    public int getIndex(int idx) {
        if (idx >= fancy.size())
            return -1;
        long l = fancy.get(idx) % MODULO;
        return (int) l;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
