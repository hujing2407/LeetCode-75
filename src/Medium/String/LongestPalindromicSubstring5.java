package Medium.String;

/**
 * @author Jing Hu
 * @date Dec. 04 2023
 */
public class LongestPalindromicSubstring5 {
    int left = 0, maxlen = 0;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        for (int i = 0; i < len - 1; i++) {
            expend(s, i, i);
            expend(s, i, i + 1);
        }
        return s.substring(left, left + maxlen);
    }

    private void expend(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (maxlen < j - i - 1) {
            left = i + 1;
            maxlen = j - i - 1;
        }
    }
}
