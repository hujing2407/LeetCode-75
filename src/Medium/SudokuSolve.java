package Medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Nov. 30 2023
 */
public class SudokuSolve {
  public void solveSudoku(char[][] board) {
    dfs(board, 0);
  }

  private boolean dfs(char[][] board, int level) {
    if (level == 81) return true;
    boolean[] flag = possibleNum(board, level); // return a boolean array
    int row = level / 9, col = level % 9;
    if (board[row][col] != '.') return dfs(board, level + 1);
    for (int i = 0; i < 9; i++) {
      if (flag[i]) {
        board[row][col] = (char) ('1' + i);
        if (dfs(board, level + 1)) return true;
      }
    }
    board[row][col] = '.';
    return false;
  }

  private boolean[] possibleNum(char[][] board, int level) {
    boolean[] flag = new boolean[9];
    Arrays.fill(flag, true);
    int row = level / 9, col = level % 9;
    for (int i = 0; i < 9; i++) {
      if (board[row][i] != '.') {
        char num = board[row][i];
        flag[num - '1'] = false;
      }
      if (board[i][col] != '.') {
        char num = board[i][col];
        flag[num - '1'] = false;
      }
      int r = row / 3 * 3 + i / 3, c = col / 3 * 3 + i % 3;
      if (board[r][c] != '.') {
        char num = board[r][c];
        flag[num - '1'] = false;
      }
    }
    return flag;
  }


}
