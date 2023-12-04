package Medium.String;

import Array.FindingUsersActiveMinutes;
import SlidingWindow.LongestSubString;

/**
 * @author Jing Hu
 * @date Jan 26 2021
 */
public class Test {
    public static void main(String[] args) {
//        test_1461();
//        test();
//        test1();
    }

    private static void test1() {
        int [][] logs = {{1,1},{2,2},{2,3}};
        int k =4;
//        int [][] logs = {{0,5},{1,2},{0,2},{0,5},{1,3}};
//        int k =5;
        FindingUsersActiveMinutes f = new FindingUsersActiveMinutes();
        int[] a = f.findingUsersActiveMinutes(logs, k);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+" ");

        }


    }

    private static void test() {
        String s = "chopper is not a tanuki";
        int k = 5;
        TruncateSentence ts = new TruncateSentence();
        System.out.println(ts.truncateSentence(s, k));
    }

    private static void test_1461() {
        ContainsAllBinaryCodes1461 cabc = new ContainsAllBinaryCodes1461();
        String s = "0000000001011100";
        int k = 4;
        System.out.println(cabc.hasAllCodes(s, k));
    }


}
