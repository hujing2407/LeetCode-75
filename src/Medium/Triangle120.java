package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jing Hu
 * @date Nov. 21 2023
 */
public class Triangle120 {
  public int minimumTotal1(List<List<Integer>> triangle) {
    // dp[i][j] = max(dp[i-1][j],dp[i-1][j-1]) + t[i][j]
    int n = triangle.size();
    int[] dp = new int[n];
    dp[0] = triangle.get(0).get(0);
    for (int i = 1; i < n; ++i) {
      dp[i] = dp[i - 1] + triangle.get(i).get(i);
      for (int j = i - 1; j > 0; --j) {
        dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
      }
      dp[0] += triangle.get(i).get(0);
    }

    int minTotal = Integer.MAX_VALUE;
    for (int d : dp) {
      minTotal = Math.min(d, minTotal);
    }
    return minTotal;
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    for (int i = triangle.size() - 2; i >= 0; --i)
      for (int j = 0; j <= i; ++j)
        triangle.get(i).set(j,triangle.get(i).get(j)+
            Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));

    return triangle.get(0).get(0);
  }
}
