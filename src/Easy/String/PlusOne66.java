package Easy.String;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 * <p>
 * Memory
 * 41.3 MB
 * Beats
 * 18.85%
 *
 * @author Jing Hu
 * @date Apr. 14 2023
 */
public class PlusOne66 {
  public int[] plusOne(int[] digits) {

    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i]++;
      digits[i] %= 10;
      if (digits[i] != 0) return digits;
    }

    if (digits[0] == 0) {
      digits = new int[digits.length + 1];
      digits[0] = 1;
    }
    return digits;
  }

}
