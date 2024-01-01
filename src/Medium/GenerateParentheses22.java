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

    public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, "", 0, 0, n);
        return list;
    }

    public void dfs(List<String> list, String s, int l, int r, int n) {
        if (l == n && r == n) list.add(s);
        if (l < n) dfs(list, s + "(", l + 1, r, n);
        if (r < l) dfs(list, s + ")", l, r + 1, n);
    }

    public static void main(String[] args) {
        GenerateParentheses22 p = new GenerateParentheses22();
        System.out.println(p.generateParenthesis1(3));
    }

}
