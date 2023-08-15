package LinearAlgebra4MA3;

/**
 * @author Jing Hu
 * @date Jun. 05 2023
 */
// Java program to find adjoint and inverse of a matrix
class GFG {

//  static final int N = 3;

  // Function to get cofactor of A[p][q] in temp[][]. n is current
// dimension of A[][]
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

// Generic function to display the matrix. We use it to display
// both adjoin and inverse. adjoin is integer matrix and inverse
// is a float.

  static void display(double A[][]) {
    int N = A.length;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        System.out.print(A[i][j] + " ");
      System.out.println();
    }
  }

  static void display(float A[][]) {
    int N = A.length;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        System.out.printf("%.6f ", A[i][j]);
      System.out.println();
    }
  }

  // Driver program
  public static void main(String[] args) {
//    int A[][] = { {5, -2, 2, 7},
//        {1, 0, 0, 3},
//        {-3, 1, 5, 0},
//        {3, -1, -9, 4}};

    double A[][] = {{1, 0.5,0.33333333},
        {0.5, 0.33333333, 0.25},
        {0.33333333,0.25,0.2}};
    int N = A.length;
    double[][] adj = new double[N][N]; // To store adjoint of A[][]

    double[][] inv = new double[N][N]; // To store inverse of A[][]

    System.out.print("Input matrix is :\n");
    display(A);

    System.out.print("\nThe Adjoint is :\n");
    adjoint(A, adj);
    display(adj);

    System.out.print("\nThe Inverse is :\n");
    if (inverse(A, inv))
      display(inv);

  }
}

// This code is contributed by Rajput-Ji