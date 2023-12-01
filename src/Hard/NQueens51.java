package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Jing Hu
 * @date Nov. 30 2023
 */
public class NQueens51 {
  HashSet<Integer> col = new HashSet<>();
  HashSet<Integer> pie = new HashSet<>();
  HashSet<Integer> na = new HashSet<>();

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    int[] pos = new int[n];
    Arrays.fill(pos, -1);
    backtrack(res, pos, n, 0, col, pie, na);

    return res;
  }

  private void backtrack(List<List<String>> res,
                         int[] pos, int n, int row,
                         HashSet<Integer> col,
                         HashSet<Integer> pie,
                         HashSet<Integer> na) {
    if (row == n) {
      List<String> board = generateBoard(pos, n);
      res.add(board);
    } else {
      for (int i = 0; i < n; i++) {
        if (col.contains(i) || pie.contains(row + i) || na.contains(row - i)) continue;
        pos[row] = i;
        col.add(i);
        pie.add(row + i);
        na.add(row - i);
        backtrack(res, pos, n, row + 1, col, pie, na);
        pos[row] = -1;
        col.remove(i);
        pie.remove(row + i);
        na.remove(row - i);
      }
    }
  }

  private List<String> generateBoard(int[] pos, int n) {
    List<String> board = new ArrayList<>();
    char[][] chars = new char[n][n];
    for (char[] c : chars) Arrays.fill(c, '.');
    for (int i = 0; i < n; i++) {
      chars[i][pos[i]] = 'Q';
      board.add(new String(chars[i]));
    }
    return board;
  }
}
