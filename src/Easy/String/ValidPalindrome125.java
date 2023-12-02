package Easy.String;

/**
 * Runtime
 * 3 ms
 * Beats
 * 97.93%
 * <p>
 * Memory
 * 42.4 MB
 * Beats
 * 88.66%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class ValidPalindrome125 {
  public boolean isPalindrome(String s) {

    int front = 0;
    int rear = s.length() - 1;

    while (front < rear) {
      while (front < s.length() && !(isAlphabelta(s.charAt(front)) || isNum(s.charAt(front)))) {
        front++;
      }
      while (rear >= 0 && !(isAlphabelta(s.charAt(rear)) || isNum(s.charAt(rear)))) {
        rear--;
      }
      if (front == s.length() || rear == -1) return true;

      int diff = s.charAt(rear) - s.charAt(front);

      if (isNum(s.charAt(front)) || isNum(s.charAt(rear))) {
        if (diff != 0) {
          return false;
        }
      }
      if (diff != 0 && diff != 32 && diff != -32) {
        return false;
      }
      front++;
      rear--;

    }
    return true;
  }

  private boolean isAlphabelta(char c) {
    if (c - 'A' >= 0 && c - 'Z' <= 0) {
      return true;
    }
    if (c - 'a' >= 0 && c - 'z' <= 0) {
      return true;
    } else return false;
  }

  private boolean isNum(char c) {
    if (c - '0' >= 0 && c - '9' <= 0) {
      return true;
    } else return false;
  }
}
