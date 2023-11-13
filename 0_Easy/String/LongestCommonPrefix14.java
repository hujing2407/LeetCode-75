package String;

/**
 * Runtime
 * 1 ms
 * Beats
 * 76.41%
 *
 * Memory
 * 40.7 MB
 * Beats
 * 56.40%
 *
 * @author Jing Hu
 * @date Apr. 13 2023
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int len = strs.length;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen,strs[i].length());
        }

        for (int i = 0; i < minLen; i++) {
            char curr = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (curr != strs[j].charAt(i)) {
                    return prefix.toString();
                }
            }
            prefix.append(curr);
        }
        return prefix.toString();
    }
}
