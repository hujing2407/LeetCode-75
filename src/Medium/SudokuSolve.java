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

  private boolean dfs(char[][] board, int i) {
    if (i == 81) return true;

    if (board[i / 9][i % 9] != '.') return dfs(board, i + 1);
    boolean[] flag = new boolean[9];
    isValid(board, i, flag);
    for (int j = 0; j < 9; j++) {
      if (flag[j]){
        board[i / 9][i % 9] = (char) ('1' + j);
        if(dfs(board, i + 1)) return true;
      }
    }
    board[i / 9][i % 9] = '.';
    return false;
  }

  private void isValid(char[][] board, int i, boolean[] flag) {
    int row = i/9, col = i%9;
    Arrays.fill(flag,true);
    for (int j = 0; j < 9; j++) {
      if(board[row][j] != '.') flag[board[row][j] -'1'] = false;
      if(board[j][col] != '.') flag[board[j][col] -'1'] = false;
      int r = row/3*3+j/3;
      int c = col/3*3+j%3;
      if(board[r][c] != '.') flag[board[r][c] -'1'] = false;
    }

  }


}
