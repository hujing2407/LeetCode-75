package MaximumNumberOfBallsInBox_1742;

/**
 * @author Jing Hu
 * @date Jan 30 2021
 */
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        int[] ints1 = new int[highLimit];

        for (int i = lowLimit; i <= highLimit ; i++) {
            int total = 0;
            String temp = i+"";
            char[] chars = temp.toCharArray();
            for (int j = 0; j < temp.length(); j++) {
                total = chars[j] -48 + total;
            }
            ints1[total-1]++;
        }

        for (int x:ints1) {
            System.out.println(x);
            max = Math.max(max,x);
        }
        return max;
    }
}
