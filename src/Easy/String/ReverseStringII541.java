package Easy.String;

/**
 * @author Jing Hu
 * @date Aug. 15 2023
 */
public class ReverseStringII541 {
  public static String reverseStr1(String s, int k) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < s.length() / (k); i++) {
      if (i % 2 == 0) {
        for (int j = k * (i + 1) - 1; j >= k * i; j--) {
          builder.append(s.charAt(j));
        }
      } else {
        for (int j = k * (i); j < k * (i + 1); j++) {
          builder.append(s.charAt(j));
        }
      }
    }
    if (s.length() / (k) % 2 == 0) {
      for (int j = s.length() - 1; j >= s.length() / (k) * k; j--) {
        builder.append(s.charAt(j));
      }
    } else {
      builder.append(s.substring(s.length() / (k) * k, s.length()));
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    String a = "onetwothree";
    String reverseStr = reverseStr(a, 2);
    System.out.println(reverseStr);
  }

  public static String reverseStr2(String s, int k) {
    StringBuilder sb = new StringBuilder();
    int len = Math.min(k, s.length());
    for (int i = len - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }
    if (s.length() <= k) {
      return sb.toString();
    } else if (s.length() <= 2 * k) {
      return sb.toString() + s.substring(k);
    } else {
      return sb.toString() + s.substring(k, 2 * k) + reverseStr2(s.substring(2 * k), k);
    }
  }

  public static String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length() - 1; i += 2 * k) {
      reverseK(i, Math.min(s.length() - 1, i + k - 1), chars);
    }
    return new String(chars);
  }

  public static void reverseK(int i, int j, char[] str) {
    while (i < j) {
      char temp = str[i];
      str[i] = str[j];
      str[j] = temp;
      i++;
      j--;
    }
  }

}
