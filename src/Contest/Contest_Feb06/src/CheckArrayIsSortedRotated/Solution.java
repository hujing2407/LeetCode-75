package CheckArrayIsSortedRotated;

/**
 * @author Jing Hu
 * @date Feb 06 2021
 */
public class Solution {
    public boolean check(int[] nums) {
        int i = 0;

        for (; i < nums.length-1; i++) {
            if(nums[i]>nums[i+1]){
                break;
            }
        }
        if (i == nums.length-1) return true;
        int temp = i;
        i++;
        for (; i < nums.length-1 ; i++) {
            if (nums[i]>nums[i+1]){
                return false;
            }
        }
        if (temp != nums.length - 1 && nums[0]>=nums[nums.length-1]) {
            return true;
        }
        return false;
    }
}
