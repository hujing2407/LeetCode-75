package Array;

import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Mar 13 2021
 */
public class FindTheDuplicateNumber287 {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            if(!hashSet.add(nums[i])){
               return nums[i];
            };
        }
        return -1;
    }
}
