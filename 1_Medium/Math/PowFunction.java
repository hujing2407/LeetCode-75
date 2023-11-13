package Math;

import java.util.ArrayList;

/**
 * @author Jing Hu
 * @date Sep. 05 2023
 */
public class PowFunction {
  public static double myPow(double x, int n) {
    boolean positiveNum = (n > 0);
    if(!positiveNum) x = 1/x;
    long num = Math.abs((long)n);
    double res = 1;
    int[] bits = new int[32];
    int i = 31;

    while (num > 0) {
      bits[i] = (int) (num & 1);
      num = num >>> 1;
      i--;
    }

    i++;
    while (i < 32) {
      if(bits[i] == 1 ){
        res *= x;
      }
      if(i < 31)res *= res;
      i++;

    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(myPow(2.0, -2147483648));
  }
}
