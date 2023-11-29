package Medium.DisjointSet;

/**
 * @author Jing Hu
 * @date Nov. 28 2023
 */
public class NumberOfIslands {
  class UnionFind{
    private int cnt = 0;
    private int[]parent;
    public UnionFind(int n){
      this.cnt = n;
      this.parent = new int[n];
      for (int i = 0; i < n; i++) {
        this.parent[i] = i;
      }
    }

    public int find(int p){
      while(p != parent[p]){
        parent[p] = parent[parent[p]];
        p = parent[p];
      }
      return p;
    }

    public void union(int p, int q){
      int rootP = find(p);
      int rootQ = find(q);
      if(rootP == rootQ) return;
      parent[rootP] = rootQ;
      cnt--;
    }
  }


  int[][] di = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};// E,S,W,N

  public int numIslands(char[][] grid) { // grid size = m x n;
    int m = grid.length;
    if(m == 0) return 0;
    int n = grid[0].length;
    UnionFind unionFind = new UnionFind(m * n);

    int zeros = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if(grid[i][j] == '1'){
          for (int[] d : di) {
            int i2 = i + d[0], j2 = j + d[1];
            if (i2 >= 0 && i2 < grid.length && j2 >= 0 && j2 < grid[0].length && grid[i2][j2] == '1') {
              unionFind.union(i*n+j, i2*n+j2);
            }
          }
        }else{
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
