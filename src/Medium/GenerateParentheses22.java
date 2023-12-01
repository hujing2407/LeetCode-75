package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jing Hu
 * @date Nov. 30 2023
 */
public class GenerateParentheses22 {
  List<String> res;

  public List<String> generateParenthesis(int n) {
    res = new ArrayList<>();
    _generate(0, 0, n, "");
    return res;
  }

  private void _generate(int l, int r, int n, String s) {
    if (l == n && r == n) {
      res.add(s);
      return;
    }
    if (l < n) _generate(l + 1, r, n, s + "(");
    if (r < n && r < l) _generate(l + 1, r, n, s + ")");
  }

}
