package Array;

/**
 * @author Jing Hu
 * @date Mar 12 2021
 */
public class AATest {
    public static void main(String[] args) {

//        test_41();
//        test_84();
//        test_84_1();
//        test_128();
        test_42();
    }

    private static void test_42() {
        TrappingRainWater42 trw = new TrappingRainWater42();
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4,2,0,3,2,5};
        System.out.println(trw.trap(height));
    }

    private static void test_128() {
        LongestConsecutiveSequence128 lrh = new LongestConsecutiveSequence128();
//        int[] nums = {100,4,200,1,3,2};
        int[] nums = {0,2147483647,2147483646,2147483645,2147483644,-2147483648,-2147483647,-2147483646};
        int i = lrh.longestConsecutive(nums);
        System.out.println(i);
    }

    private static void test_84_1() {
        LargestRectangleInHistogram_84_1 lrh = new LargestRectangleInHistogram_84_1();
        int[] nums = {2, 1, 5, 6, 2, 3};
        int i = lrh.largestRectangleArea(nums);
        System.out.println(i);
    }

    private static void test_84() {
        LargestRectangleInHistogram_84 lrh = new LargestRectangleInHistogram_84();
        int[] nums = {2, 1, 5, 6, 2, 3};
//        int[] nums = {2, 4};
//        int[] nums = {0,2,3,3,3,5,4,2,2,1,1};
//        int[] nums = {7,8,9,11,12};
        int i = lrh.largestRectangleArea(nums);
        System.out.println(i);
    }

    static void test_41() {
        FirstMissingPositive_41 fmp = new FirstMissingPositive_41();
//        int[] nums = {1,2,0};
//        int[] nums = {-4,-1,-1,-3};
//        int[] nums = {0,2,3,3,3,5,4,2,2,1,1};
//        int[] nums = {7,8,9,11,12};
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12};
        int x = fmp.firstMissingPositive(nums);
        System.out.println(x);
    }

}
