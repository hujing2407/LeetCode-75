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
        int[] newNums = new int[m + n];
        int index = 0;
        int mp = 0;
        int np = 0;
        while (mp<m && np<n){

            if (nums1[mp] < nums2[np]) {
                newNums[index++] = nums1[mp++];
            }else{
                newNums[index++] = nums2[np++];
            }
        }
        if(mp == m){
            while(np<n) newNums[index++] = nums2[np++];
        }else{
            while(mp<m) newNums[index++] = nums1[mp++];
        }
        for (int i = 0; i < m+n; i++) {
            nums1[i] = newNums[i];
        }
    }
}
