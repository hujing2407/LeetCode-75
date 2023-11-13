package Array;

import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Sep. 05 2023
 */
public class SetMatrixZeroes {
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[] row = new int[m];
    int[] col = new int[n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if(matrix[i][j] == 0) {
          row[i] = 1;
          col[j] = 1;
        }
      }
    }

    for (int i = 0; i < row.length; i++) {
      if (row[i] == 1) {
        for (int j = 0; j < col.length; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < col.length; i++) {
      if (col[i] == 1) {
        for (int j = 0; j < row.length; j++) {
          matrix[j][i] = 0;
        }
      }
    }
  }
}
