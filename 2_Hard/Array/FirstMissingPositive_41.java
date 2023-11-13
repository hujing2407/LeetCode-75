package Array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Jing Hu
 * @date Mar 11 2021
 */
public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        // in case is empty
        if (nums.length==0) return 1;
        // sort
        Arrays.sort(nums);
        // remove duplicate
        int[] newNums = new int[nums.length];
        int index = 0;
        newNums[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=newNums[index]){
                index++;
                newNums[index] = nums[i];
            }
        }
        // skip negitive num and zero
        int count = 0;
        while (count < newNums.length && newNums[count] <= 0) {
            count++;
        }

        // compare one by one
        if (count < newNums.length && newNums[count] > 1) {
            return 1;
        } else {
            for (int i = count; i < newNums.length; i++) {
                if (newNums[i] != i - count + 1) {
                    return i - count + 1;
                }
            }
        }
        return newNums.length - count + 1;
    }
}
