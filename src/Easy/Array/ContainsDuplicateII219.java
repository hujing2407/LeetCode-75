package Easy.Array;

import java.util.HashMap;

/**
 * Runtime
 * 20 ms
 * Beats
 * 81.71%
 *
 * Memory
 * 51.2 MB
 * Beats
 * 53.81%
 *
 * @author Jing Hu
 * @date Apr. 16 2023
 */
public class ContainsDuplicateII219 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])){
        int pre = map.get(nums[i]);
        if (pre >= i-k) {
          return true;
        }
      }
        map.put(nums[i], i);
    }

    return false;
  }
}
