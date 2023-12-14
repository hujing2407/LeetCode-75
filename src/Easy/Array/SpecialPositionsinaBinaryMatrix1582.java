package Easy.Array;

import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Dec. 13 2023
 */
public class SpecialPositionsinaBinaryMatrix1582 {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0;
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) res++;

        return res;
    }
}
