package Easy;

/**
 * @author Jing Hu
 * @date May 15 2023
 */
public class GaussElim {

  static double[] GaussElimination(double a[][]) {
    int n = a.length;

    return GaussElimination(n, a);
  }

  /**
   * Implements a Gaussian elimination on the given matrix. The matrix
   * <code>a</code> should be n rows by n+1 columns. Column <code>n+1</code>
   * being the Right Hand Side values.
   *
   * @param n the number of rows in the matrix.
   * @param a the matrix to be solved.
   */
  static double[] GaussElimination(int n, double a[][]) {
    // Forward elimination
    for (int k = 0; k < n - 1; k++) {
      for (int i = k + 1; i < n; i++) {
        double qt = a[i][k] / a[k][k];
        for (int j = k + 1; j < n + 1; j++)
          a[i][j] -= qt * a[k][j];

        a[i][k] = 0.0;
      }
    }

        /**/
        // DEBUG
        for ( int i=0; i<n; i++ )
        for ( int j=0; j<n+1; j++ )
        System.out.println( "After forward elimination, a["+i+"]["+j+"]="+a[i][j] );


    double x[] = new double[n];

    // Back-substitution
    x[n - 1] = a[n - 1][n] / a[n - 1][n - 1];
    for (int k = n - 2; k >= 0; k--) {
      double sum = 0.0;
      for (int j = k + 1; j < n; j++)
        sum += a[k][j] * x[j];

      x[k] = (a[k][n] - sum) / a[k][k];
    }

        /* */
        // DEBUG
        for ( int k=0; k<n; k++ )
        System.out.println( "After back-substitution, x["+k+"]="+x[k] );


    return x;
  }
}
