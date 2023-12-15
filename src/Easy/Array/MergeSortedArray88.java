package Easy.Array;

import java.util.Arrays;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 42.9 MB
 * Beats
 * 21.69%
 *
 * @author Jing Hu
 * @date Apr. 14 2023
 */
public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        m--;
        n--;
        while(m >= 0 && n >= 0){
            if(nums1[m] > nums2[n]) nums1[pos--] = nums1[m--];
            else nums1[pos--] = nums2[n--];
        }
        if(m < 0) {
            for(int i = 0; i<= n; i++) nums1[i] = nums2[i];
        }
    }
}
