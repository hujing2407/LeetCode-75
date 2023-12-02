package Medium;

/**
 * @author Jing Hu
 * @date Dec. 01 2023
 */
public class SudokuSolve1 {
  public void solveSudoku(char[][] board) {
    if (board == null || board.length == 0) return;
    solve(board);
  }

  private boolean solve(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') continue;
        for (char c = '1'; c <= '9'; c++) {
          if (valid(board, i, j, c)) {
            board[i][j] = c;
            if (solve(board)) return true;
            board[i][j] = '.';
          }
        }
        return false;
      }
    }
    return true;
  }

  private boolean valid(char[][] board, int row, int col, char c) {

    for (int k = 0; k < 9; k++) {
      if(board[row][k] == c) return false;
      if(board[k][col] == c) return false;
      int rb = row/3*3+k/3, cb = col/3*3+k%3;
      if(board[rb][cb] == c) return false;
    }
    return true;
  }


}
