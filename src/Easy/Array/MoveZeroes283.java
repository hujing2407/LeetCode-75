package Easy.Array;

/**
 * Runtime
 * 1 ms
 * Beats
 * 99.98%
 *
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
    int i = 0;
    int scan = 0;
    while (scan < nums.length){
      if (nums[scan] != 0) {
        nums[i] = nums[scan];
        i++;
      }

      scan++;
    }

    while(i<nums.length){
      nums[i] = 0;
      i++;
    }
  }
}
