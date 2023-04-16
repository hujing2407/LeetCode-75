package Bits;

/**
 * Runtime
 * 1 ms
 * Beats
 * 93.67%
 *
 * Memory
 * 41.9 MB
 * Beats
 * 71.74%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class ReverseBits190 {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      res <<= 1;
      byte b = (byte) (n % 2);
      res += b;
      // Must use unsign bit move operator
      n >>>= 1;
    }
    return res;
  }
}
