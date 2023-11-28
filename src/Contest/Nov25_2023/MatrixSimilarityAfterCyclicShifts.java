package Contest.Nov25_2023;

/**
 * @author Jing Hu
 * @date Nov. 25 2023
 */
public class MatrixSimilarityAfterCyclicShifts {
  public static boolean areSimilar(int[][] mat, int k) {
    if(k%mat[0].length == 0) return true;
    int n = mat[0].length;
    int di = k;
    for (int i = 0; i < mat.length; i++) {
      if ((i & 1) == 0) {
        di = -k;
      }else{
        di = k;
      }
      for (int j = 0; j < n; j++) {
        if(mat[i][j] != mat[i][(j+di+n)%n]) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] test = {{1,2,1,2},{5,5,5,5},{6,3,6,3}};
    System.out.println(areSimilar(test,2));
  }

}
