package MedianofTwoSortedArrays;

/**
 * @author Jing Hu
 * @date Jan 26 2021
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        if (m == 0) return median(nums2);
        int n = nums2.length;
        if (n == 0) return median(nums1);
        int i = 0;
        int j = 0;
        int index = 0;
        double median = 0.0;
        boolean isFinish = true; // nums1 is finished?

        int[] merge = new int[m + n];
        while (true) {
            if (nums1[i] < nums2[j]) {
                merge[index] = nums1[i];
                i++;
                index++;
            } else {
                merge[index] = nums2[j];
                j++;
                index++;
            }

            if (m == i) {
                break;
            }
            if (n == j) {
                isFinish = false;
                break;
            }
        }
        if (isFinish) {
            for (; j < n; j++) {
                merge[index] = nums2[j];
                index++;
            }
        } else {
            for (; i < m; i++) {
                merge[index] = nums1[i];
                index++;
            }
        }
        return median(merge);
    }

    private double median(int[] arr) {
        double m;
        int l = arr.length;
        if (l % 2 == 1) {
            m = arr[l / 2];
            return m;
        } else {
            m = (arr[l / 2 - 1] + arr[l / 2]) / 2.0;
            return m;
        }
    }
}
