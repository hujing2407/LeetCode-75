package Medium.DisjointSet;

/**
 * @author Jing Hu
 * @date Nov. 28 2023
 */
public class NumberOfIslands {

  int[][] di = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};// E,S,W,N

  public int numIslands(char[][] grid) { // grid size = m x n;
    int m = grid.length;
    if (m == 0) return 0;
    int n = grid[0].length;
    UnionFind unionFind = new UnionFind(m * n);

    int zeros = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          for (int[] d : di) {
            int i2 = i + d[0], j2 = j + d[1];
            if (i2 >= 0 && i2 < grid.length && j2 >= 0 && j2 < grid[0].length && grid[i2][j2] == '1') {
              unionFind.union(i * n + j, i2 * n + j2);
            }
          }
        } else {
          zeros++;
        }
      }
    }

    return unionFind.cnt - zeros;
  }

  public static void main(String[] args) {
    NumberOfIslands is = new NumberOfIslands();
    char[][] grid = {
        {'1', '1', '1'},
        {'1', '1', '0'},
        {'1', '0', '1'}};
    System.out.println(is.numIslands(grid));
  }
}
