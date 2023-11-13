package July2022;

import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Jul 16 2022
 */
public class MaximumNumberofPairsinArray_6120 {
    public int[] numberOfPairs(int[] nums) {
        int[] ints = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for (int i: nums) {
            if(set.contains(i)){
                ints[0]++;
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        ints[1] = set.size();
        return ints;
    }
}

