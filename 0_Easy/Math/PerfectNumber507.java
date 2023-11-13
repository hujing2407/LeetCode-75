package Math;

import java.util.ArrayList;

/**
 * @author Jing Hu
 * @date Aug. 15 2023
 */
public class PerfectNumber507 {
  public static boolean checkPerfectNumber(int num) {
    if(num == 1) return false;
    int i = 2;
    int root = (int) Math.sqrt(num);
    int sum = 1;
    while (i <= root) {
      if (num % i == 0) {
        sum += i;
        sum += (num / i);
      }
      i++;
    }

    return sum == num?true:false;
  }

  public static void main(String[] args) {
    checkPerfectNumber(28);
  }
}
