package Medium.String;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jing Hu
 * @date Dec. 02 2023
 */
public class ReverseWordsInString151 {
  public static String reverseWords1(String s) {
    String[] ss = s.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = ss.length - 1; i >= 0; i--) {
      if (ss[i].length() == 0) continue;
      sb.append(ss[i]);
      sb.append(" ");
    }
    String s2 = sb.toString();
    return s2.substring(0, s2.length() - 1);
  }

  public static String reverseWords(String s) {
    int l = 0, r = s.length() - 1;
    while (l <= r && s.charAt(l) == ' ') ++l;
    while (l <= r && s.charAt(r) == ' ') --r;
    Deque<String> deq = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    while (l <= r) {
      if (sb.length() != 0 && s.charAt(l) == ' ') {
        deq.offerFirst(new String(sb));
        sb.setLength(0);
      }
      if (s.charAt(l) != ' ') {
        sb.append(s.charAt(l));
      }
      ++l;
    }
    deq.offerFirst(new String(sb));
    return String.join(" ",deq);
  }

  public static void main(String[] args) {
    System.out.println(reverseWords("  the sky is blue  "));
  }
}
