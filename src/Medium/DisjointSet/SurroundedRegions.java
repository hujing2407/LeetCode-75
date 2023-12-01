package Medium.DisjointSet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jing Hu
 * @date Nov. 30 2023
 */
public class SurroundedRegions {

  public void solve(char[][] board) {

    if (board == null || board.length == 0) return;
    int m = board.length, n = board[0].length;

    int dummyNode = m * n;
    UnionFind unionFind = new UnionFind(m * n + 1);

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O') {
          if (i == 0 || j == 0 || i == m - 1 || j == n - 1) unionFind.union(i * n + j, dummyNode);
          else {
            if (i > 0 && board[i - 1][j] == 'O') unionFind.union(node(i - 1, j, n), node(i, j, n));
            if (i < m - 1 && board[i + 1][j] == 'O') unionFind.union(node(i + 1, j, n), node(i, j, n));
            if (j > 0 && board[i][j - 1] == 'O') unionFind.union(node(i, j - 1, n), node(i, j, n));
            if (j < n - 1 && board[i][j + 1] == 'O') unionFind.union(node(i, j + 1, n), node(i, j, n));
          }
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (unionFind.isConnected(node(i,j,n),dummyNode)) board[i][j] = 'O';
        else board[i][j] = 'X';
      }
    }
  }

  private int node(int i, int j, int col) {
    return i * col + j;
  }
}
