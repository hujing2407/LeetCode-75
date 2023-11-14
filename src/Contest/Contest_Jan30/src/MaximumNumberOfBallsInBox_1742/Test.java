package MaximumNumberOfBallsInBox_1742;

/**
 * @author Jing Hu
 * @date Jan 30 2021
 */
public class Test {
    public static void main(String[] args) {
        int lowlimit = 19;

        int highlimit = 28;
        Solution solution = new Solution();
//        char a = '0';
//        System.out.println(a);
        int countBalls = solution.countBalls(lowlimit, highlimit);
        System.out.println(countBalls);
    }



}
