package Medium.String;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jing Hu
 * @date Nov. 16 2023
 */
public class LetterCombinationsofaPhoneNumber17 {
  public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
    if (digits.isEmpty()) return ans;
    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    for (int i = 0; i < digits.length(); i++) {
      int x = Character.getNumericValue(digits.charAt(i));
      while (ans.peek().length() == i) {
        String curr = ans.remove();
        for (char c : mapping[x].toCharArray()) {
          ans.add(curr+c);
        }
      }
    }

    return ans;
  }
}
