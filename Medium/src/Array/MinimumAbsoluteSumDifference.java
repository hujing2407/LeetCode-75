package Array;

import java.util.TreeSet;

/**
 * @author Jing Hu
 * @date Apr 03 2021
 */
public class MinimumAbsoluteSumDifference {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = 1000000007;
        int totalDif=0;
        int index = 0;

        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++) {
            ts.add(nums1[i]);
        }

        int maxDiffChange = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i]-nums2[i]);
            totalDif += diff;
            totalDif %= mod;

            int minDiff= diff;
            if(ts.contains(nums2[i])){
                minDiff = 0;
            }else{
                Integer near = ts.higher(nums2[i]);
                if(near != null){
                    minDiff = near - nums2[i];
                }
                near = ts.lower(nums2[i]);
                if(near != null){
                    minDiff = Math.min(minDiff,nums2[i]-near);
                }
            }

            maxDiffChange = Math.max(maxDiffChange,diff-minDiff);

        }


        return (totalDif-maxDiffChange)%mod;
    }
}
