package Array;

import java.util.HashSet;

/**
 * Runtime
 * 11 ms
 * Beats
 * 85.38%
 *
 * Memory
 * 56.2 MB
 * Beats
 * 60.22%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class ContainsDuplicate217 {
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      }
      set.add(nums[i]);
    }
    return false;
  }
}
