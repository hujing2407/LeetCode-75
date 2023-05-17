
/**
 * @author Jing Hu
 * @date May 15 2023
 */
public class LinearAlgebraAssign2 {
  public static void main(String[] args) {

    double[][] A = {{1,2,1,-1},
                    {3,2,4,4},
                    {4,4,3,4},
                    {2,0,1,5}};
    double[] b = {5,16,22,15};
    double[][] Ab = {{1,2,1,-1,5},
                    {3,2,4,4,16},
                    {4,4,3,4,22},
                    {2,0,1,5,15}};
    double[] res = GaussElim.GaussElimination(Ab);
    System.out.println(res);
    gaussElimination(A);
//    double[] y = forwardSubstitutionFunction(A, b);
//    double[] res = backwardSubstitutionFunction(A, y);
//    System.out.println(res);

//    double[][] LU = Test.lu(A);
//
//    // forward substitution
//    double[] y = new double[b.length];
//    for(int i=0;i<y.length;i++){
//      double sum = 0.0;
//      for(int j=0;j<i;j++){
//        sum += LU[i][j]*y[j];
//      }
//      y[i] = (b[i] - sum);
//    }
//    // backward substitution
//    double[] x = new double[b.length];
//    for(int i=x.length-1;i>=0;i--){
//      double sum = 0.0;
//      for(int j=i+1;j<x.length;j++){
//        sum += LU[i][j]*x[j];
//      }
//      x[i] = (y[i] - sum)/LU[i][i];
//    }
  }

  public static double[] forwardSubstitutionFunction(double[][] L, double[] b) {

    int n = L.length;
    double[] x = new double[n];
    for (int j = 0; j < n; j++) {
      if (L[j][j] == 0) break;
      x[j] = b[j]/L[j][j];
      for (int i = j+1; j < n; j++) {
        b[i] = b[i] - x[j]*L[j][j];
      }
    }
    return x;
  }

  public static double[] backwardSubstitutionFunction(double[][] U, double[] b) {

    int n = U.length;
    double[] x = new double[n];
    for (int i = n-1; i >=0; i--) {
      if (U[i][i] == 0) break;
      x[i] = b[i]/U[i][i];
      for (int j =1; j < i-1; j++) {
        b[j] = b[j] - x[j]*U[j][j];
      }
    }
    return x;
  }

  public static void gaussElimination(double[][] A) {

    int n = A.length;
    double[][] m = new double[n][n];
    for (int k = 1; k < n; k++) {
      if (A[k][k] == 0) break;

      for (int i =k+1; i < n; i++) {
        m[i][k] = A[i][k]/A[k][k];
      }

      for (int j = k+1; j < n; j++) {
        for (int i = k+1; i < n; i++) {
          A[i][j] = A[i][j]-m[i][k]*A[k][j];
        }
      }

    }
  }


}
