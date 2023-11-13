package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jing Hu
 * @date Mar 12 2021
 */
public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        // add all elements to HashSet and remove duplicate meanwhile
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // search from a end point ( num-1 is not in set)
        int longest = 0;
        for (int s : set) {
            if (s == Integer.MIN_VALUE || !set.contains(s - 1)) {
                int curr = s;
                int currLength = 0;
                while (set.contains(curr) && curr <= Integer.MAX_VALUE) {
                    curr++;
                    currLength++;
                }
                longest = Math.max(longest, currLength);
            }

        }
        return longest;
    }
}
