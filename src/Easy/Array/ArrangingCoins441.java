package Easy.Array;

/**
 * @author Jing Hu
 * @date May 09 2023
 */
public class ArrangingCoins441 {
  public int arrangeCoins(int n) {
    if (n < 0) {
      return -1;
    }
    return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
  }

  public int arrangeCoins1(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Input Number is invalid. Only positive numbers are allowed");
    }
    if (n <= 1) {
      return n;
    }
    if (n <= 3) {
      return n == 3 ? 2 : 1;
    }

    // Binary Search space will start from 2 to n/2.
    long start = 2;
    long end = n / 2;
    while (start <= end) {
      long mid = start + (end - start) / 2;
      long coinsFilled = mid * (mid + 1) / 2;
      if (coinsFilled == n) {
        return (int) mid;
      }
      if (coinsFilled < n) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return (int) end;
  }
}
