package Medium.Array;

/**
 * @author Jing Hu
 * @date Dec. 14 2023
 */
public class DifferenceBetweenOnesandZeros2482 {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowOnes = new int[m], colOnes = new int[n];
        for (int i = 0; i < m; i++) {
            int one = 0;
            for (int j = 0; j < n; j++) {
                one += grid[i][j];
            }
            rowOnes[i] = one;
        }
        for (int jj = 0; jj < n; jj++) {
            int one = 0;
            for (int ii = 0; ii < m; ii++) {
                one += grid[ii][jj];
            }
            colOnes[jj] = one;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 2 * (rowOnes[i] + colOnes[j]) - m - n;
            }
        }
        return grid;
    }
}
