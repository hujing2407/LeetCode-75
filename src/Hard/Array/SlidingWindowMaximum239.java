package Hard.Array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jing Hu
 * @date Dec. 30 2023
 */
public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        LinkedList<Integer> max = new LinkedList<>();
        int[] res = new int[nums.length - k+1];

        for(int i = 0; i<k; i++){
            while(!max.isEmpty() && nums[max.getLast()]<= nums[i]) max.removeLast();
            max.addLast(i);
        }

        res[0] = nums[max.getFirst()];
        for(int i = k; i<nums.length; i++){
            while(!max.isEmpty() && i- max.getFirst() >= k) max.removeFirst();
            while(!max.isEmpty() && nums[max.getLast()]<= nums[i]) max.removeLast();
            max.addLast(i);
            res[i-k+1]= nums[max.getFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,4};
        SlidingWindowMaximum239 s = new SlidingWindowMaximum239();
        System.out.println(s.maxSlidingWindow(nums, 2));
    }

}
