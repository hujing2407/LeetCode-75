package Easy.Array;


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

  private static int helper(int[] nums, int i, int major) {
    int count = 0;
    for (int j = i; j < nums.length; j++) {
      if (major == nums[j]) {
        count++;
      }else{
        count--;
      }
      if(count == -1){
        return helper(nums,j,nums[j]);
      }
    }
    return major;
  }


}

