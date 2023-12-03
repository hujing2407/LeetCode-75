package Easy.String;

import java.util.Arrays;

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
        /**
         *  0ms, 100%
         */
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

        /**
         *  1ms, 71%
         */
//        Arrays.sort(strs);
//        int n = strs.length;
//        StringBuilder sb = new StringBuilder();
//        String s1 = strs[0],s2 = strs[n-1];
//        int len1 = Math.max(s1.length(),s2.length());
//        for (int i = 0; i < len1; i++) {
//            if(s1.charAt(i) == s2.charAt(i)) sb.append(s1.charAt(i));
//            else break;
//        }
//        return sb.toString();
    }
}
