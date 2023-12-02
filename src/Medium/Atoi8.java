package Medium;

/**
 * @author Jing Hu
 * @date Dec. 01 2023
 */
public class Atoi8 {
  public static int myAtoi(String s) {
    if (s == null || s.length() == 0) return 0;
    int res = 0, idx = 0, sign = 1;
    while (idx < s.length() && s.charAt(idx) == ' ') idx++;
    if (idx == s.length()) return 0;
    if (s.charAt(idx) == '+' || s.charAt(idx) == '-') {
      if (s.charAt(idx) == '+') sign = 1;
      else sign = -1;
      idx++;
    }
    while (idx < s.length()) {
      if (s.charAt(idx) > '9' || s.charAt(idx) < '0') return sign * res;
      int digit = s.charAt(idx) - '0';
      if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      res = res * 10 + digit;
      idx++;
    }
    return sign * res;
  }


  /*
  public int myAtoi(String s) {
    String str = s;
    int index = 0, sign = 1, total = 0;
    //1. Empty string
    if (str.length() == 0) return 0;
    //2. Remove Spaces
    while (index < str.length() && str.charAt(index) == ' ') index++;
    if (index == str.length()) return 0;
    //3. Handle signs
    if (str.charAt(index) == '+' || str.charAt(index) == '-') {
      sign = str.charAt(index) == '+' ? 1 : -1;
      index++;
    }
    //4. Convert number and avoid overflow
    while (index < str.length()) {
      int digit = str.charAt(index) - '0';
      if (digit < 0 || digit > 9) break;
      //check if total will be overflow after 10 times and add digit
      if (Integer.MAX_VALUE / 10 < total ||
          Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      total = 10 * total + digit;
      index++;
    }
    return total * sign;
  }*/

  public static void main(String[] args) {
    System.out.println(myAtoi("42"));
  }
}
