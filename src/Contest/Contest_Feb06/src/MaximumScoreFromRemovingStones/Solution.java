package MaximumScoreFromRemovingStones;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Jing Hu
 * @date Feb 06 2021
 */
public class Solution {
    public int maximumScore(int a, int b, int c) {

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(a);
        nums.add(b);
        nums.add(c);
        Collections.sort(nums);
        if(nums.get(0)+nums.get(1) <= nums.get(2)){
            return nums.get(0)+nums.get(1);
        }else{
                return (a+b+c)/2;

        }
    }
}
