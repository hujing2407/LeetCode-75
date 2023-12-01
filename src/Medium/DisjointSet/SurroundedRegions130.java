package Medium.DisjointSet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jing Hu
 * @date Nov. 30 2023
 */
public class SurroundedRegions130 {
  int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};//E,S,W,N

  public void solve(char[][] board) {
    if (board == null || board.length == 0) return;
    int m = board.length, n = board[0].length;

    /* DFS =>
    for (int i = 0; i < m; i++) {
        dfs(board,  i, 0);
        dfs(board,  i, n - 1);
    }

    for (int i = 0; i < n; i++) {
        dfs(board,  0, i);
        dfs(board,  m - 1, i);
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if(board[i][j] == 'A') board[i][j] = 'O';
        else board[i][j] = 'X';
      }
    }*/

    /* BFS => */
    Deque<Integer> q = new LinkedList();
    for (int i = 0; i < m; i++) { // row iterate
      if (board[i][0] == 'O') {
        q.offer(i * n);
        board[i][0] = 'A';
      }
      if (board[i][n - 1] == 'O') {
        q.offer(i * n + (n - 1));
        board[i][n - 1] = 'A';
      }
    }

    for (int i = 0; i < n; i++) { // col iterate
      if (board[0][i] == 'O') {
        q.offer(i);
        board[0][i] = 'A';
      }
      if (board[m - 1][i] == 'O') {
        q.offer((m - 1) * n + i);
        board[m - 1][i] = 'A';
      }
    }

    while (!q.isEmpty()) {
      int pos = q.pop();
      for (int[] di : dir) {
        int i2 = pos / n + di[0], j2 = pos % n + di[1];
        if (i2 < 0 || i2 >= m || j2 < 0 || j2 >= n || board[i2][j2] != 'O') {
          continue;
        }
        q.offer(i2 * n + j2);
        board[i2][j2] = 'A';
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'A') board[i][j] = 'O';
        else board[i][j] = 'X';
      }
    }
  }

  private void dfs(char[][] board, int i, int j) {
    if (board[i][j] == 'X' || board[i][j] == 'A') return;
    board[i][j] = 'A';
    for (int[] di : dir) {
      int i2 = i + di[0], j2 = j + di[1];
      if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
        dfs(board, i2, j2);
      }
    }
  }
}
