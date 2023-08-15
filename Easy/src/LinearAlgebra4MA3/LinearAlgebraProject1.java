package LinearAlgebra4MA3;

/**
 * @author Jing Hu
 * @date Jun. 05 2023
 */
public class LinearAlgebraProject1 {


  public static void main(String[] args) {
    int n = 2;
    boolean next = true;
    while (next) {
      System.out.printf("\n===== n = %d =====\n", n);
      double[][] hb = generatorHb(n);

//      System.out.println("\nThe Hb matrix is:");
      outputMatrix(hb);

//    System.out.println("\nLU decomposition using Gauss Elimination:");
      gaussElimination(hb);

//    System.out.println("\nBackward Substitution:");
      double[] res = backwardSubstitution(hb);
      System.out.println("Calculated vector x:");
      outputVector(res);

//      System.out.println("\nThe final answer is:");
//      for (int i = 0; i < res.length; i++) {
//        System.out.printf("%.5f\t",res[i]);
//      }
//      System.out.println();
      hb = generatorHb(n);
      double[] x_diff = new double[n];
      for (int i = 0; i < n; i++) {
        x_diff[i] = res[i] - 1;
        if (Math.abs(x_diff[i])/1 > 1 ) {
          next = false;
        }
      }
      System.out.println("Diff vector x_diff:");
      outputVector(x_diff);

      double[] r = new double[n];
      double infinite_norm_r = 0;
      // calculate the infinite norm of the residual r
      for (int i = 0; i < n; i++) {
        double temp = 0;
        for (int j = 0; j < n; j++) {
          temp += hb[i][j] * res[j];
        }
        r[i] = temp - hb[i][n];
        infinite_norm_r =
            infinite_norm_r>Math.abs(r[i])?infinite_norm_r:Math.abs(r[i]);
      }
      // vector r:
      System.out.println("vector r:");
      outputVector(r);
      System.out.println("infinite norm of r:");
      System.out.println(infinite_norm_r);

      // Calculate Cond(H)
      double[][] H = new double[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          H[i][j] = hb[i][j];
        }
      }

      double normH = infinite_norm(H);
      System.out.println("infinite norm of H:");
      System.out.println(normH);


      double[][] inverse = new double[n][n];
      inverse(H,inverse);
//      double[][] adj = new double[N][N]; // To store adjoint of A[][]
//
//      double[][] inv = new double[N][N]; // To store inverse of A[][]

//      System.out.print("Input matrix is :\n");
//      display(A);
//
//      System.out.print("\nThe Adjoint is :\n");
//      adjoint(A, adj);
//      display(adj);

//      System.out.print("\nThe Inverse is :\n");
//      if (inverse(A, inv))
//        display(inv);
//      GFG.inverse(H,inverse);
      double normInverse = infinite_norm(inverse);
      System.out.println("infinite norm of H_inverse:");
      System.out.println(normInverse);

      double cond = normH * normInverse;
      System.out.println("infinite cond of H:");
      System.out.println(cond);

      // next nxn matrix
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
      for (int i = 0; i < j; i++) {
        U[i][n] = U[i][n] - x[j] * U[i][j];
      }
    }
    return x;
  }

  public static void gaussElimination(double[][] A) {

    int n = A.length;
    double[][] m = new double[n][n + 1];
    for (int k = 0; k < n - 1; k++) {
      if (A[k][k] == 0) break;

      for (int i = k + 1; i < n; i++) {
        m[i][k] = A[i][k] / A[k][k];
      }

      for (int j = k; j < n + 1; j++) {
        for (int i = k + 1; i < n; i++) {
          A[i][j] = A[i][j] - m[i][k] * A[k][j];
        }
      }
    }
  }

  public static void outputMatrix(double[][] Ab) {
    int n = Ab.length;
    for (double[] doubles : Ab) {
      for (int j = 0; j < n + 1; j++)
        System.out.printf("%f\t", doubles[j]);
      System.out.println();
    }
  }

  public static void outputVector(double[] r) {
    for (int j = 0; j < r.length; j++)
      System.out.printf("%f\t", r[j]);
    System.out.println();
  }

  public static double infinite_norm(double[][] m){
    double cond = 0;
    for (int i = 0; i < m.length; i++) {
      double temp = 0;
      for (int j = 0; j < m[0].length; j++) {
        temp += Math.abs(m[i][j]);
      }
      cond = cond > temp?cond:temp;
    }
    return cond;
  }

  static void getCofactor(double A[][], double temp[][], int p, int q, int n) {
    int i = 0, j = 0;

    // Looping for each element of the matrix
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        // Copying into temporary matrix only those element
        // which are not in given row and column
        if (row != p && col != q) {
          temp[i][j++] = A[row][col];

          // Row is filled, so increase row index and
          // reset col index
          if (j == n - 1) {
            j = 0;
            i++;
          }
        }
      }
    }
  }

  /* Recursive function for finding determinant of matrix.
  n is current dimension of A[][]. */
  static double determinant(double A[][], int n) {
    int D = 0; // Initialize result
    int N = A.length;
    // Base case : if matrix contains single element
    if (n == 1)
      return A[0][0];

    double[][] temp = new double[N][N]; // To store cofactors

    int sign = 1; // To store sign multiplier

    // Iterate for each element of first row
    for (int f = 0; f < n; f++) {
      // Getting Cofactor of A[0][f]
      getCofactor(A, temp, 0, f, n);
      D += sign * A[0][f] * determinant(temp, n - 1);

      // terms are to be added with alternate sign
      sign = -sign;
    }

    return D;
  }

  // Function to get adjoint of A[N][N] in adj[N][N].
  static void adjoint(double A[][], double[][] adj) {
    int N = A.length;
    if (N == 1) {
      adj[0][0] = 1;
      return;
    }

    // temp is used to store cofactors of A[][]
    int sign = 1;
    double[][] temp = new double[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        // Get cofactor of A[i][j]
        getCofactor(A, temp, i, j, N);

        // sign of adj[j][i] positive if sum of row
        // and column indexes is even.
        sign = ((i + j) % 2 == 0) ? 1 : -1;

        // Interchanging rows and columns to get the
        // transpose of the cofactor matrix
        adj[j][i] = (sign) * (determinant(temp, N - 1));
      }
    }
  }

  // Function to calculate and store inverse, returns false if
// matrix is singular
  static boolean inverse(double A[][], double[][] inverse) {
    // Find determinant of A[][]
    int N = A.length;
    double det = determinant(A, N);
    if (det == 0) {
      System.out.print("Singular matrix, can't find its inverse");
      return false;
    }

    // Find adjoint
    double[][] adj = new double[N][N];
    adjoint(A, adj);

    // Find Inverse using formula "inverse(A) = adj(A)/det(A)"
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        inverse[i][j] = adj[i][j] / (double) det;

    return true;
  }
}
