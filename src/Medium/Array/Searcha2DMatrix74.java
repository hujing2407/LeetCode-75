package Medium.Array;

/**
 * @author Jing Hu
 * @date Nov. 21 2023
 */
public class Searcha2DMatrix74 {
  public static boolean searchMatrix1(int[][] matrix, int target) {
    int row = matrix.length, col = matrix[0].length;
    int l = 0, r = row - 1;
    while (l != r) {
      int m = l + (r - l) / 2;
      if (matrix[m][col - 1] < target) l = m + 1;
      else r = m;
    }

    if (matrix[l][col - 1] < target) return false;

    int curr = l;
    l = 0;
    r = col - 1;
    while (l != r) {
      int m = l + (r - l) / 2;
      //   if (matrix[curr][m] == target) return true;
      if (matrix[curr][m] < target) {
        l = m + 1;
      } else {
        r = m;
      }
    }
    return matrix[curr][l] == target;
  }

  public static boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length, col = matrix[0].length;
    int l = 0, r = row * col - 1;
    while(l != r){
      int m = l + (r-l)/2;
      if (matrix[m/col][m%col] < target) l = m + 1;
      else r = m;
    }
    return matrix[r/col][r%col] == target;
  }

  public static void main(String[] args) {
    int[][] nums = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    System.out.println(searchMatrix(nums, 3));
  }
}
