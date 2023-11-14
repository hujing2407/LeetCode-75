package Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jing Hu
 * @date Nov. 13 2023
 */
public class ThreeSum15 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> lists = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) return lists;
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      int l = i + 1, r = nums.length - 1;
      while (l < r) {
        if (nums[i] + nums[l] + nums[r] == 0) {
          lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
          while (l < r && nums[l] == nums[l + 1]) l++;
          while (l < r && nums[r] == nums[r - 1]) r--;
          l++;
          r--;
        } else if (nums[i] + nums[l] + nums[r] < 0) {
          l++;
        } else {
          r--;
        }
      }
    }
    return lists;
  }
}
