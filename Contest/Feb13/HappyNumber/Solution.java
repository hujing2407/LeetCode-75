package Feb13.HappyNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jing Hu
 * @date Feb 13 2021
 */
public class Solution {
    public boolean isHappy1(int n) {
        int sum = 0;
        int num = n;
        ArrayList<Integer> als = new ArrayList<Integer>();

        while (true) {
            String nStr = num + "";
            for (int i = 0; i < nStr.length(); i++) {
                sum = sum + (nStr.charAt(i) - 48) * (nStr.charAt(i) - 48);
            }
//            System.out.print(sum + " ");
            if (sum == 1) {
                return true;
            } else if (als.contains(sum)) {
                return false;
            } else {
                als.add(sum);
                num = sum;
                sum = 0;
            }
        }
    }

    /**
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int sum = 0;
        int num = n;
        int bit = 0;
        Set<Integer> set = new HashSet<Integer>();

        while (set.add(sum)) {
            sum = 0;
            while (num > 0) {
                bit = num % 10;
                sum = sum + bit * bit;
                num = num /10;
            }
            if (sum == 1) {
                return true;
            } else {
                num = sum;
            }
        }
        return false;
    }
}
