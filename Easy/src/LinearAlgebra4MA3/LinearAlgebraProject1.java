package LinearAlgebra4MA3;

/**
 * @author Jing Hu
 * @date Jun. 05 2023
 */
public class LinearAlgebraProject1 {


  public static void main(String[] args) {
    int n = 1;
    while(n<13){
      System.out.printf("\n===== n = %d =====",n);
      double[][] hb = generatorHb(n);

      System.out.println("\nThe Hb matrix is:");
      outputMatrix(hb);

//    System.out.println("\nLU decomposition using Gauss Elimination:");
      gaussElimination(hb);

//    System.out.println("\nBackward Substitution:");
      double[] res = backwardSubstitution(hb);

//      System.out.println("\nThe final answer is:");
//      for (int i = 0; i < res.length; i++) {
//        System.out.printf("%.5f\t",res[i]);
//      }
//      System.out.println();



      n++;
    }
  }

  public static double[][] generatorHb(int n) {
    double[][] Hb = new double[n][n + 1];
    for (int i = 0; i < n; i++) {
      double b = 0;
      for (int j = 0; j < n; j++) {
        Hb[i][j] = 1.0 / (i + j + 1);
        b += Hb[i][j];
      }
      Hb[i][n] = b;
    }
    return Hb;
  }


  public static double[] forwardSubstitution(double[][] L) {

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

  public static double[] backwardSubstitution(double[][] U) {

    int n = U.length;
    double[] x = new double[n];
    for (int j = n - 1; j >= 0; j--) {
      if (U[j][j] == 0) break;
      x[j] = U[j][n] / U[j][j];
      for (int i = 0; i < j ; i++) {
        U[i][n] = U[i][n] - x[j] * U[i][j];
      }
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
    }
  }

  public static void outputMatrix(double[][] Ab){
    int n = Ab.length;
    System.out.println("----");
    for (double[] doubles : Ab) {
      for (int j = 0; j < n + 1; j++)
        System.out.printf("%.5f\t", doubles[j]);
      System.out.println();
    }
  }


}
