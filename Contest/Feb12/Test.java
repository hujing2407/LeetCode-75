package Feb12;

import java.util.Currency;
import java.util.Date;
import java.util.Random;

/**
 * @author Jing Hu
 * @date Feb 12 2021
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "1";
        Random random = new Random();
        for (int i = 0; i < 500; i++) {
            s1 += Long. toBinaryString(random.nextLong());
        }
        System.out.println(s1.length());
        Solution s = new Solution();
//        System.out.println(s.numberOfSteps(14));
//        System.out.println(s.numSteps("1101"));
        long date1 = System.currentTimeMillis();
        System.out.println(s.numSteps1(s1));
        long date2 = System.currentTimeMillis();
        System.out.println("Running time: " + (date2 - date1) + " MilliSecond!");
        System.out.println(s.numSteps(s1));
        long date3 = System.currentTimeMillis();
        System.out.println("Running time: " + (date2 - date1) + " MilliSecond!");
    }
}
