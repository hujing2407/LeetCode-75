package Medium.DisjointSet;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jing Hu
 * @date Nov. 28 2023
 */
public class NumberofIslands200 {
  int[][] di = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};// E,S,W,N

  public int numIslands(char[][] grid) {
    int cnt = 0;
    int m = grid.length, n = grid[0].length;
//    boolean[][] visited = new boolean[m][n];

    /* DFS
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          dfs(grid,i,j);
          cnt++;
        }
      }
    }*/

    /* BFS
    Deque<Integer> q = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          q.offer(i * n + j);
          grid[i][j] = '0';
          while (!q.isEmpty()) {
            int pos = q.pop();
            for (int[] d : di) {
              int i2 = pos / n + d[0], j2 = pos % n + d[1];
              if (i2 >= 0 && i2 < m && j2 >= 0 && j2 < n && grid[i2][j2] == '1') {
                q.offer(i2 * n + j2);
                grid[i2][j2] = '0';
              }
            }
          }
          cnt++;
        }
      }
    }*/


    return cnt;
  }

  private void dfs(char[][] grid, int i, int j) {
    if (grid[i][j] == '0') return;
    grid[i][j] = '0';
    for (int[] d : di) {
      int i2 = i + d[0], j2 = j + d[1];
      if (i2 >= 0 && i2 < grid.length && j2 >= 0 && j2 < grid[0].length) {
        dfs(grid, i2, j2);
      }
    }
  }

  public static void main(String[] args) {
    NumberofIslands200 is = new NumberofIslands200();
    char[][] grid = {
        {'1', '1', '1'},
        {'1', '1', '0'},
        {'1', '0', '1'}};
    System.out.println(is.numIslands(grid));
  }
}
