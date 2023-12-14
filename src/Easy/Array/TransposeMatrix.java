package Easy.Array;

/**
 * @author Jing Hu
 * @date Dec. 10 2023
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] newM = new int[n][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                newM[j][i] = matrix[i][j];
            }
        }
        return newM;
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        TransposeMatrix t = new TransposeMatrix();
        int[][] transpose = t.transpose(m);
    }
}
