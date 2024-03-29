package Easy.String;

/**
 * @author Jing Hu
 * @date Aug. 15 2023
 */
public class ReverseWordsInAStringIII557 {
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

  public static String reverseWords(String s) {
    char[] chs = s.toCharArray();
    int len = chs.length;
    for (int i = 0; i < len; i++) {
      while (i < len && chs[i] == ' ') i++;
      int j = i;
      while (j < len && chs[j] != ' ') j++;
      if (i != j-1) {
        reverse(chs,i,j-1);
        i = j;
      }
    }
    return new String(chs);
  }

  public static void main(String[] args) {
    System.out.println(reverseWords("Let's take LeetCode contest"));
  }
}
