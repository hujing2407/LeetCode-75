package Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jing Hu
 * @date Nov. 23 2023
 */
public class CoinChange322 {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
//    dp[0] = 0;
    for (int i = 0; i < amount + 1; i++) {
      for (int coin : coins) {
        if (i < coin) continue;
        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
      }
    }
    return (dp[amount] == amount + 1) ? -1 : dp[amount];
  }
}
