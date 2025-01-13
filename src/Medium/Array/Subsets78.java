package Array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jing Hu
 * @date Mar 12 2021
 */
public class Subsets78 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(new ArrayList<Integer>());

        for (int i = 0; i < nums.length; i++) { // list length = i
            for (int j = 0, size = list.size(); j < size; j++) { //
                List<Integer> curr = new ArrayList<>(list.get(j));
                curr.add(nums[i]);
                list.add(curr);
            }
        }
        return list;
    }
}
