package Contest.Dec09_2023;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Jing Hu
 * @date Dec. 09 2023
 */
public class DoubleModularExponentiation {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0], b = variables[i][1], c = variables[i][2], d = variables[i][3];
            a %= 10;
            int m = mymod(b, a, 10);
            int n = mymod(c, m, d);
            if (n % d == target)
                list.add(i);
        }
        return list;
    }

    private int mymod(int b, int a, int mod) {
        if (b == 0) return 1;
        if (b == 1) return a%mod;
        return mymod(b / 2, a, mod) * mymod(b - b / 2, a,mod)%mod;
    }

    public static void main(String[] args) {
        int[][] v = {{2,2,3,2},{1,3,3,2},{3,2,2,3},{3,1,2,3},{1,2,3,1},{2,2,2,2},{2,1,3,1},{3,2,2,2},{2,1,3,1},{3,3,1,3}};
        DoubleModularExponentiation dou = new DoubleModularExponentiation();
        System.out.println(dou.getGoodIndices(v, 0));
    }
}
