package Feb12.FactorialTrailingZeroes;

/**
 * @author Jing Hu
 * @date Feb 12 2021
 */
class Solution {
    public int trailingZeroes(int n) {
        int num5 = 0;
        String s = n+"";
        for (int i = 5; i <= n; i *= 5) {
            num5 += n/i;
        }
        return num5;
//        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
//        return num5 = n/5 + n/25 + n/125 + n/625 + n/3125;
    }
    public int trailingZeroes1(int n) {
        int count = 0;
        while (n != 0) {
            int tmp = n / 5;
            count += tmp;
            n = tmp;
        }
        return count;
    }
}
