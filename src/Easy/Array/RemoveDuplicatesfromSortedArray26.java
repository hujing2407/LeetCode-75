package Array;

/**
 * Runtime
 * 1 ms
 * Beats
 * 99.97%
 *
 * Memory
 * 44.5 MB
 * Beats
 * 16.18%
 *
 * @author Jing Hu
 * @date Apr. 13 2023
 */
public class RemoveDuplicatesfromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        int index = 0;
        while(index<nums.length){
            int curr = nums[index];
            index++;
            while (index<nums.length && curr==nums[index]){
                index++;
            }
            nums[len] = curr;
            len++;
        }
        return len;
    }
}
