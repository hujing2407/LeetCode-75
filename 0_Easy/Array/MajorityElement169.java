package Array;


import static java.util.Arrays.sort;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 46.2 MB
 * Beats
 * 58.86%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class MajorityElement169 {
  public static int majorityElement(int[] nums) {
    return helper(nums, 0, nums[0]);
  }

  static int helper(int[] nums, int si, int ref) {
    int count = 0;
    for (int i = si; i < nums.length; i++) {
      if (ref == nums[i]) {
        count++;
      } else {
        count--;
      }

      if (count == -1) {
        return helper(nums, i, nums[i]);
      }
    }
    return ref;
  }
}

