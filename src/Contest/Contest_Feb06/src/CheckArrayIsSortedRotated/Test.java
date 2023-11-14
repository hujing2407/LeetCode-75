package CheckArrayIsSortedRotated;

/**
 * @author Jing Hu
 * @date Feb 06 2021
 */
public class Test {
    public static void main(String[] args) {

//        int[] nums = {3,4,5,1,2};
//        int[] nums = {2,1,3,4};
//        int[] nums = {1,2,3};
//        int[] nums = {1,1,1};
        int[] nums = {2,1};
        Solution solution = new Solution();
        boolean check = solution.check(nums);
        System.out.println(check);
    }
}
