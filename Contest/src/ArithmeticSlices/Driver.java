package ArithmeticSlices;

/**
 * @author Jing Hu
 * @date Feb 18 2021
 */
public class Driver {
    public static void main(String[] args) {
        int[] a = {1,2,3,8,9,10};
        Solution solution = new Solution();
        int i = solution.numberOfArithmeticSlices(a);
        System.out.println(i);
    }
}
