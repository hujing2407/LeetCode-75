package MedianofTwoSortedArrays;

/**
 * @author Jing Hu
 * @date Jan 26 2021
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {3};
        int[] nums2 = {-2,-1};

        double m = solution.findMedianSortedArrays(nums1,nums2);
        System.out.println(m);
    }
}
