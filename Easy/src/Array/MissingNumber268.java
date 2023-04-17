package Array;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 43.5 MB
 * Beats
 * 31.96%
 *
 * @author Jing Hu
 * @date Apr. 17 2023
 */
public class MissingNumber268 {
  public int missingNumber(int[] nums) {
    int sum = 0;
    for (int i: nums
         ) {
      sum += i;
    }
    int n = nums.length;
    int diff = n*(n+1)/2 - sum;
    return diff;
  }
}
