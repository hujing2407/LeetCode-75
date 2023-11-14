package Easy.Array;

/**
 * Runtime
 * 1 ms
 * Beats
 * 99.98%
 * <p>
 * Memory
 * 44.1 MB
 * Beats
 * 41.3%
 *
 * @author Jing Hu
 * @date Apr. 17 2023
 */
public class MoveZeroes283 {
  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;

    int index = 0;
    for (int num : nums) {
      if (num != 0) nums[index++] = num;
    }

    while (index < nums.length) nums[index++] = 0;
  }
}
