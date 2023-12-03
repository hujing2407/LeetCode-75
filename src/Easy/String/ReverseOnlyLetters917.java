package Easy.String;

import static java.lang.Character.isLetter;

/**
 * @author Jing Hu
 * @date Aug. 15 2023
 */
public class ReverseOnlyLetters917 {
  public String reverseWords1(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] != ' ') {   // when chars[i] is a non-space
        int j = i;
        while (j + 1 < chars.length && chars[j + 1] != ' ') {
          j++;
        } // move j to the end of the word
        reverse(chars, i, j);
        i = j;
      }
    }
    return new String(chars);
  }

  private static void reverse(char[] chars, int i, int j) {
    for (; i < j; i++, j--) {
      char tmp = chars[i];
      chars[i] = chars[j];
      chars[j] = tmp;
    }
  }

  private static boolean isLetter(char c) {
    if (c <= 'z' && c >= 'a') return true;
    if (c <= 'Z' && c >= 'A') return true;
    return false;
  }

  public static String reverseOnlyLetters(String s) {
    char[] chs = s.toCharArray();
    int l = 0, r = s.length() - 1;
    while (l < r) {
      while(l<r && !Character.isLetter(chs[l])) l++;
      while(l<r && !Character.isLetter(chs[r])) r--;
      char tmp = chs[l];
      chs[l] = chs[r];
      chs[r] = tmp;
      l++;
      r--;
    }
    return new String(chs);
  }

  public static void main(String[] args) {
    System.out.println(reverseOnlyLetters("Test1ng-Leet(=code-Q!"));
  }
}
