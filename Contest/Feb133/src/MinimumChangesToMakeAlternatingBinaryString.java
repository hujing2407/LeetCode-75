import static java.lang.Integer.toUnsignedString;

/**
 * @author Jing Hu
 * @date Feb 13 2021
 */
public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        char[] chars1 = s.toCharArray();
        int n1 = 0;//异或第一种情况
        int n2 = 0;
        for (int i = 0; i < s.length() ; i++) {
            if (i % 2 == 0) {
                if (chars1[i] == '0') {
                    n2++;
                } else {
                    n1++;

                }
            } else {
                if (chars1[i] == '0') {
                    n1++;
                } else {
                    n2++;
                }
            }
        }
        return Math.min(n1, n2);
    }

}
