package FancySequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Jing Hu
 * @date Feb 05 2021
 */
public class OtherFancy {
    final int mod = 1000000007;
    List<Integer> ls;
    Random rnd;

    class LinOperator {
        int mult;
        int add;

        LinOperator(int a, int b) {
            mult = a;
            add = b;
        }

        LinOperator(long a, long b) {
            mult = (int) (a % mod);
            add = (int) (b % mod);
        }

        int calc(int x) {
            return (int) ((mult * 1l * x + add) % mod);
        }
    }


    LinOperator mult(LinOperator a, LinOperator b) {
        if (a == null) return b;
        if (b == null) return a;
        LinOperator ret = new LinOperator(
                a.mult * 1L * b.mult,
                b.add + b.mult * 1L * a.add
        );
        return ret;
    }


    class TreeElem {
        LinOperator one;
        LinOperator all;
        int pos;
        double weight;
        TreeElem left;
        TreeElem right;
    }

    LinOperator all(TreeElem e) {
        return e == null ? null : e.all;
    }


    TreeElem addNext(TreeElem elem, LinOperator operator, int pos, double w) {
        if (elem == null) {
            TreeElem r = new TreeElem();
            r.all = r.one = operator;
            r.pos = pos;
            r.weight = w;
            return r;
        }

        if (elem.weight < w) {
            TreeElem r = new TreeElem();
            r.one = operator;
            r.all = mult(elem.all, operator);
            r.pos = pos;
            r.weight = w;
            r.left = elem;
            return r;
        }

        elem.right = addNext(elem.right, operator, pos, w);
        elem.all = mult(all(elem.left), mult(elem.one, all(elem.right)));
        return elem;
    }

    TreeElem root;


    LinOperator getMore(TreeElem elem, int value) {
        if (elem == null) return null;
        if (elem.pos <= value) return getMore(elem.right, value);

        return mult(
                getMore(elem.left, value),
                mult(elem.one, all(elem.right))

        );
    }

    public OtherFancy() {
        ls = new ArrayList<>();
        rnd = new Random(42);
    }

    public void append(int val) {
        ls.add(val);
    }

    public void addAll(int inc) {
        root = addNext(root, new LinOperator(1, inc), ls.size(), rnd.nextDouble());
    }

    public void multAll(int m) {
        root = addNext(root, new LinOperator(m, 0), ls.size(), rnd.nextDouble());
    }

    public int getIndex(int idx) {
        if (idx >= ls.size()) return -1;
        LinOperator op = getMore(root, idx);
        if (op == null) return ls.get(idx);
        return op.calc(ls.get(idx));
    }

}
