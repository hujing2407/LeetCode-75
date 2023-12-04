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

    int n = s.length(), l = 0, r = n - 1;
    while (l < r) {
      while (l < n && !Character.isLetterOrDigit(s.charAt(l))) l++;
      while (r >= 0 && !Character.isLetterOrDigit(s.charAt(r))) r--;
      if (l < n && r >= 0 &&
          Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }
}
