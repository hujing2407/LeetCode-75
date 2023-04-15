/**
 * @author Jing Hu
 * @date Apr. 14 2023
 */
public class ClimbingStairs70 {

    /**
     * Time Limit Exceeded
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 2) return 2;
        if (n == 1) return 1;

        return climbStairs(n-1)+climbStairs(n-2);
    }

    /*
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int a = 1;
        int b = 2;

        for(int i = 3; i <= n; i++)
        {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }*/
}
