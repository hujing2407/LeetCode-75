package Contest.Nov17_2023;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Jing Hu
 * @date Nov. 18 2023
 */
public class Solution {
  public static int findMinimumOperations(String s1, String s2, String s3) {
    int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
    int n = Math.min(n1, n2);
    n = Math.min(n, n3);
    if (s1.charAt(0) != s2.charAt(0) || s1.charAt(0) != s3.charAt(0)) return -1;
    for (int i = 1; i < n; i++) {
      char c = s1.charAt(i);
      if (c != s2.charAt(i) || c != s3.charAt(i)) {
        n = i;
        break;
      }
    }

    return (n1 + n2 + n3) - 3 * n;
  }

  public static long minimumSteps(String s) {
//    char[] chars = s.toCharArray();
//    int p0 = 0, p1 = 0, n = 0;
//    while (p1 < s.length()) {
//
//      while (p1 < s.length() && chars[p1] == '0') p1++;
//      p0 = p1;
//      while (p0 < s.length() && chars[p0] != '0') p0++;
//      if (p0 == s.length()) break;
//      n += (p0 - p1);
//      chars[p0] = '1';
//      p1++;
//    }
    long n = 0;
    for (int i = 0, cnt = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') ++cnt;
      else n += cnt;
    }
    return n;
  }

  public static int maximumXorProduct(long a, long b, int n) {
    int mod = 1000000007;

    for (int i = n - 1; i >= 0; i--) {
      long bit = 1l << i;
      if ((a & bit) > 0 && (b & bit) > 0) {
        continue;
      } else if ((a & bit) > 0) {
        if (a > b) {
          a ^= bit;
          b |= bit;
        }
      } else if ((b & bit) > 0) {
        if (a < b) {
          a |= bit;
          b ^= bit;
        }
      } else {
        a |= bit;
        b |= bit;
      }
    }
    a %= mod;
    b %= mod;
    return (int) ((a * b) % mod);
  }

  public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
    return null;
  }


  public static void main(String[] args) {
//    int i = findMinimumOperations("acc",
//        "accacb",
//        "acbabc");
//    System.out.println(i);
//
//    long i = minimumSteps("100000");
//    System.out.println(i);

    System.out.println(maximumXorProduct(12, 5, 4));
  }

}
