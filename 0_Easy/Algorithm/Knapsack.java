package Algorithm;

/**
 * @author Jing Hu
 * @date Aug. 31 2023
 */
public class Knapsack {
  public static void main(String[] args) {
    int[] weight = {1, 4, 3};
    int[] value = {1500, 3000, 2000};
    int capacity = 4;
    int n = weight.length;

    int[][] totalValue = new int[n + 1][capacity + 1];

    int[][] items = new int[n + 1][capacity + 1];

    // set the first row and first column to "0"
    for (int i = 0; i < totalValue.length; i++) {
      totalValue[i][0] = 0;
      totalValue[0][i] = 0;
    }

    for (int i = 1; i < totalValue.length; i++) {
      for (int j = 1; j < totalValue[0].length; j++) {
        if (weight[i - 1] > j) {
          totalValue[i][j] = totalValue[i - 1][j];
        } else {
//          totalValue[i][j] = Math.max(totalValue[i-1][j], totalValue[i-1][j-weight[i-1]]+value[i-1]);
          if(totalValue[i-1][j] > totalValue[i-1][j-weight[i-1]]+value[i-1]){
            totalValue[i][j] = totalValue[i-1][j];
          }else {
            totalValue[i][j] = totalValue[i-1][j-weight[i-1]]+value[i-1];
            items[i][j] = 1;
          }

        }
      }
    }

    for (int i = 0; i < totalValue.length; i++) {
      for (int j = 0; j < totalValue[0].length; j++) {
        System.out.print(totalValue[i][j]+ " ");
      }
      System.out.println();
    }

    for (int i = 0; i < totalValue.length; i++) {
      for (int j = 0; j < totalValue[0].length; j++) {
        System.out.print(items[i][j]+ " ");
      }
      System.out.println();
    }

    int i = items.length -1;
    int j = items[0].length -1;
    while(i>0 && j>0 ){
      if(items[i][j] ==1){
        System.out.printf("Item %d\n",i);
        j -= weight[i-1];// weight array shorter than items'
      }
      i--;
    }
  }
}
