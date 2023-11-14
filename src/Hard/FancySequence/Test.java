package FancySequence;

import java.util.ArrayList;

/**
 * @author Jing Hu
 * @date Jan 30 2021
 */

//["Fancy","append","getIndex","multAll","multAll","getIndex","addAll",
// "append","append","getIndex","append","append","addAll","getIndex",
// "multAll","addAll","append","addAll","getIndex","getIndex","multAll",
// "multAll","multAll","append","addAll","getIndex","getIndex","getIndex",
// "append","getIndex","addAll","multAll","append","multAll","addAll","getIndex",
// "append","append","addAll","getIndex","multAll","getIndex","addAll","getIndex",
// "multAll","addAll","getIndex","addAll","append","append","append","multAll","multAll",
// "append","multAll","addAll","getIndex","addAll","multAll","multAll","multAll","append",
// "multAll","append","multAll","addAll","append","append","getIndex","getIndex","getIndex",
// "addAll","multAll","multAll","append","append","getIndex","append","append","append","getIndex","getIndex"]
//[[],[5],[0],[14],[10],[0],[12],[10],[4],[2],[4],[2],[1],[1],[8],[11],[15],[12],[0],[3],
// [4],[11],[11],[10],[8],[2],[3],[0],[7],[3],[2],[6],[10],[6],[8],[7],[9],[9],[12],[0],
// [13],[7],[3],[4],[8],[14],[2],[9],[9],[9],[7],[5],[12],[9],[3],[8],[10],[14],[14],[14],
// [6],[1],[3],[11],[12],[6],[7],[13],[12],[5],[6],[1],[11],[11],[4],[9],[7],[11],[1],[3],[1],[0]]

public class Test {

    class Fancy {
        private ArrayList<Long> lst;
        private ArrayList<Long> add;
        private ArrayList<Long> mult;
        private final long MOD = 1000000007;

        public Fancy() {
            lst = new ArrayList<>();
            add = new ArrayList<>();
            mult = new ArrayList<>();
            add.add(0L);
            mult.add(1L);
        }

        public void append(int val) {
            lst.add((long) val);
            int l = add.size();
            add.add(add.get(l - 1));
            mult.add(mult.get(l - 1));
        }

        public void addAll(int inc) {
            int l = add.size();
            add.set(l - 1, add.get(l - 1) + inc);
        }

        public void multAll(int m) {
            int l = add.size();
            add.set(l - 1, (add.get(l - 1) * m) % MOD);
            mult.set(l - 1, (mult.get(l - 1) * m) % MOD);
        }

        public int getIndex(int idx) {
            if (idx >= lst.size()) return -1;

            int l = add.size();
            long m = (mult.get(l - 1) * inverse(mult.get(idx))) % MOD;
            long a = (add.get(l - 1) - (add.get(idx) * m) % MOD + MOD) % MOD;
            return (int) (((lst.get(idx) * m) % MOD + a) % MOD);
        }

        long inverse(long a) {
            return pow(a, MOD - 2);
        }

        long pow(long a, long n) {
            if (n == 0) return 1;
            if (n % 2 == 0) {
                long t = pow(a, n / 2);
                return (t * t) % MOD;
            } else {
                return (pow(a, n - 1) * a) % MOD;
            }
        }
    }

}
