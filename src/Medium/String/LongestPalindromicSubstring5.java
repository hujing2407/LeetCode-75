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
        String res = "";
        boolean[][] dp = new boolean[len][len];
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }

                if (dp[i][j] && j - i + 1 > res.length()) res = s.substring(i, j + 1);
            }
        }
        return res;
    }

    public String longestPalindrome2(String s) {
        int l = 0, r = 0, max = 1, n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; ++i){
            dp[i][i] = true;
            for (int j = 0; j < n; ++j){
                if(s.charAt(i)==s.charAt(j) && (i-j <= 2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                    if (i - j + 1 > max) {
                        max = i - j + 1;
                        l = j;
                        r = i;
                    }
                }
            }
        }
        return s.substring(l, r+1);
    }

    public String longestPalindrome1(String s) {
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
