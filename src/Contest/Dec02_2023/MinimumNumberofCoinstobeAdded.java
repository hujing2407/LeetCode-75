package Contest.Dec02_2023;

import javax.swing.*;
import java.util.*;

/**
 * @author Jing Hu
 * @date Dec. 02 2023
 */
public class MinimumNumberofCoinstobeAdded {
  public int minimumAddedCoins(int[] coins, int target) {
    Arrays.sort(coins);
    int res = 0, s = 1, cnt = 0;
    while (s <= target) {
      if (cnt < coins.length && coins[cnt] <= s) {
        s += coins[cnt];
        cnt++;
      } else{
        s *= 2;
        res++;
      }
    }
    return res;
  }


  public static void main(String[] args) {
    int[] coins = {1, 1, 1};
    int t = 7;
    MinimumNumberofCoinstobeAdded m = new MinimumNumberofCoinstobeAdded();
    m.minimumAddedCoins(coins, t);
  }
}
