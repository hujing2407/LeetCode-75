package Bits;

/**
 * Runtime
 * 1 ms
 * Beats
 * 100%
 *
 * Memory
 * 39.7 MB
 * Beats
 * 77.62%
 *
 * @author Jing Hu
 * @date Apr. 16 2023
 */
public class PowerofTwo231 {
  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }
    int b = n & (n - 1);
    return b==0;
  }
}
