package Bits;

/**
 * Runtime
 * 1 ms
 * Beats
 * 100%
 *
 * Memory
 * 42.3 MB
 * Beats
 * 68.34%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class ExcelSheetColumnNumber171 {
  public int titleToNumber(String s) {
    int res = 0;
    int len = s.length();
    for (int i = 0; i < len; i++) {
      int temp = s.charAt(i) - 'A';
      res = res * 26 + temp + 1;
    }
    return res;
  }
}
