package Math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jing Hu
 * @date Aug. 22 2023
 */
public class CountPrimes {
  public static int countPrimes(int n) {
    if (n < 3) {
      return 1;
    }

    int count = 0;
    boolean[] isNotPrime = new boolean[n];
    for (int i = 3; i * i < n; i += 2) {
      if (isNotPrime[i]) {
        continue;
      }
      for (int j = i; j < n; j += 2 * i) {
        isNotPrime[j] = true;
      }
    }
    for (int i = 3; i < n; i += 2) {
      if (!isNotPrime[i]) count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countPrimes(499979));
  }
}
