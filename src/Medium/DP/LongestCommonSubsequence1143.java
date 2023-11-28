package Medium.DP;

/**
 * @author Jing Hu
 * @date Nov. 28 2023
 */
public class LongestCommonSubsequence1143 {
  public static int longestCommonSubsequence(String text1, String text2) {
    int len1 = text1.length() + 1, len2 = text2.length() + 1;
    int[] dp = new int[len2];

    for (int i = 1; i < len1; i++) {
      int preColpreRow = dp[0];
      for (int j = 1; j < len2; j++) {
        int prev = dp[j];
        if (text1.charAt(i-1) == text2.charAt(j-1)) dp[j] = preColpreRow + 1;
        else dp[j] = Math.max(dp[j], dp[j - 1]);
        preColpreRow = prev;
      }
    }
    return dp[len2 - 1];
  }

  public static void main(String[] args) {
    String a = "aa", b = "aaa";
    System.out.println(longestCommonSubsequence(a, b));
  }
}
