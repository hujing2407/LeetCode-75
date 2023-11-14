package RestoretheArrayFromAdjacentPairs_1743;

/**
 * @author Jing Hu
 * @date Jan 30 2021
 */
public class Test {
    public static void main(String[] args) {
        int[][] adj = {{4,-2},{1,4},{-3,1}};


        Solution solution = new Solution();
        int[] ints = solution.restoreArray(adj);

//        AnotherSolution solution1 = new AnotherSolution();
//        ints = solution1.restoreArray(adj);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}
