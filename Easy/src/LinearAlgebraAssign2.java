
/**
 * @author Jing Hu
 * @date May 15 2023
 */
public class LinearAlgebraAssign2 {
  public static void main(String[] args) {

    double[][] Ab = {{1, 2, 1, -1, 5},
        {3, 2, 4, 4, 16},
        {4, 4, 3, 4, 22},
        {2, 0, 1, 5, 15}};
    System.out.println("\nThe original matrix is:");
    outputMatrix(Ab);

    System.out.println("\nLU decomposition using Gauss Elimination:");
    gaussElimination(Ab);

    System.out.println("\nBackward Substitution:");
    double[] res = backwardSubstitutionFunction(Ab);

    System.out.println("\nThe final answer is:");
    for (int i = 0; i < res.length; i++) {
      System.out.printf("x[%d] = %.2f\n",i+1,res[i]);
    }
    System.out.println();

  }

  public static double[] forwardSubstitutionFunction(double[][] L) {

    int n = L.length;
    double[] x = new double[n];
    for (int j = 0; j < n; j++) {
      if (L[j][j] == 0) break;
      x[j] = L[j][n] / L[j][j];
      for (int i = j + 1; j < n; j++) {
        L[i][n] = L[i][n] - x[j] * L[i][j];
      }
    }
    return x;
  }

  public static double[] backwardSubstitutionFunction(double[][] U) {

    int n = U.length;
    double[] x = new double[n];
    for (int j = n - 1; j >= 0; j--) {
      if (U[j][j] == 0) break;
      x[j] = U[j][n] / U[j][j];
      for (int i = 0; i < j ; i++) {
        U[i][n] = U[i][n] - x[j] * U[i][j];
      }
      outputMatrix(U);
    }
    return x;
  }

  public static void gaussElimination(double[][] A) {

    int n = A.length;
    double[][] m = new double[n][n+1];
    for (int k = 0; k < n - 1; k++) {
      if (A[k][k] == 0) break;

      for (int i = k + 1; i < n; i++) {
        m[i][k] = A[i][k] / A[k][k];
      }

      for (int j = k; j < n+1; j++) {
        for (int i = k + 1; i < n; i++) {
          A[i][j] = A[i][j] - m[i][k] * A[k][j];
        }
      }
      outputMatrix(A);
    }
  }

  public static void outputMatrix(double[][] Ab){
    int n = Ab.length;
    System.out.println("----");
    for ( int i=0; i<n; i++ ) {
      for (int j = 0; j < n + 1; j++)
        System.out.printf("%.2f\t", Ab[i][j]);
      System.out.println();
    }
  }
}


