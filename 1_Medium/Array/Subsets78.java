package Array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jing Hu
 * @date Mar 12 2021
 */
public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new LinkedList<>();
        LinkedList<List> subSets = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) { // list length = i
            for (int j = 0; j <= i; j++) { //
                for (int k = j; k < j; k++) {

                }
            }
        }
        return null;
    }
}
