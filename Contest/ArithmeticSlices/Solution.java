package ArithmeticSlices;

import java.util.ArrayList;

/**
 * @author Jing Hu
 * @date Feb 18 2021
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int l = A.length;
        if (l < 3) return 0;
        int totalCount = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int subLength = 2;
        int step = A[1] - A[0];
        for (int i = 2; i < l; i++) {
            if (A[i] - A[i - 1] == step) {
                subLength++;
            } else {
                if (subLength > 2) {
                    list.add(subLength);
                }
                step = A[i] - A[i - 1];
                subLength = 2;
            }
        }
        if (subLength > 2) list.add(subLength);
        System.out.println(list.toString());
        for (int x : list) {
            totalCount = totalCount + number(x);
        }
        return totalCount;
    }

    public int number(int l) {
        int count = 0;
        for (int subNum = l - 2; subNum > 0; subNum--) {
            count = count + subNum;
        }
        return count;
    }

    public int numberOfArithmeticSlices1(int[] A) {
        int l = A.length;
        int count = 0;
        for (int subNum = 3; subNum <= l; subNum++) {

            for (int step = 1; step <= l / 2; step++) {

                inner:
                for (int i = 0; i <= l - 2 * step; i++) {
                    if (i + (subNum - 1) * step < l) {
                        count++;
                    } else {
                        break inner;
                    }
                }
            }
        }
        return count;
    }
}
