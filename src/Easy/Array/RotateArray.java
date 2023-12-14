package Easy.Array;

/**
 * @author Jing Hu
 * @date Aug. 17 2023
 */
public class RotateArray {
  public void rotate(int[] nums, int k) {
    if(k>nums.length) k = k%nums.length;
    int[] rotated = new int[k];
    for (int i = nums.length - k; i < nums.length; i++) {
      rotated[i - nums.length + k] = nums[i];
    }
    for (int i = nums.length - k - 1 ; i >=0; i--) {
      nums[i+k] = nums[i];
    }
    for (int i = 0; i < k; i++) {
      nums[i] = rotated[i];
    }
  }
}
