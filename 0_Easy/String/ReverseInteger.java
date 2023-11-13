package String;

/**
 * @author Jing Hu
 * @date Aug. 23 2023
 */
public class ReverseInteger {
  public static int reverse(int x) {
    if (x == 0) {
      return 0;
    }
    boolean sign = x > 0;
    int abs = Math.abs(x);
    long res = 0;
    while (abs > 0) {
      res *= 10;
      res += abs % 10;
      abs /= 10;
    }
    if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
      return 0;
    }
    return (int) (sign ? res : -res);
  }


  public static void main(String[] args) {
    System.out.println(reverse(1534236469));
  }
}
