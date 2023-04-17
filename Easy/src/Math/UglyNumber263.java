package Math;

/**
 * Runtime
 * 1 ms
 * Beats
 * 100%
 *
 * Memory
 * 40.3 MB
 * Beats
 * 12.15%
 *
 * @author Jing Hu
 * @date Apr. 17 2023
 */
public class UglyNumber263 {
  public boolean isUgly(int n) {
    if (n == 0) return false;
    while (n % 2 == 0) n /= 2;
    while (n % 3 == 0) n /= 3;
    while (n % 5 == 0) n /= 5;
    if (n == 1) {
      return true;
    } else {
      return false;
    }
  }
}
