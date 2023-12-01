package Medium.DisjointSet;

/**
 * @author Jing Hu
 * @date Nov. 30 2023
 */
public class UnionFind {
  protected int cnt = 0;
  protected int[] parent;

  public UnionFind(int n) {
    this.cnt = n;
    this.parent = new int[n];
    for (int i = 0; i < n; i++) {
      this.parent[i] = i;
    }
  }

  public int find(int p) {
    while (p != parent[p]) {
      parent[p] = parent[parent[p]];
      p = parent[p];
    }
    return p;
  }

  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) return;
    parent[rootP] = rootQ;
    cnt--;
  }
  public boolean isConnected(int p, int q) {
    return find(p) == find(q);
  }

}