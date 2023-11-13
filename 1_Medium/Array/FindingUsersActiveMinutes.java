package Array;

import java.util.*;

/**
 * @author Jing Hu
 * @date Apr 03 2021
 */
public class FindingUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ints = new int[k];
        int[] id = new int[logs.length];
        HashMap<Integer, LinkedHashSet> map = new HashMap<>();

        for (int[] a:logs) {
            if(map.get(a[0]) == null){
                LinkedHashSet<Integer> set = new LinkedHashSet<>();
                set.add(a[1]);
                map.put(a[0],set);
            }else{
                map.get(a[0]).add(a[1]);
            }
        }

        for (Integer a:map.keySet()) {
            Set times = map.get(a);
            ints[times.size()-1]++;
        }
        return ints;
    }
}
