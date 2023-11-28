package Medium;

import java.util.Arrays;

/**
 * @author Jing Hu
 * @date Nov. 25 2023
 */
public class MergeIntervals56 {
  public static int[][] merge(int[][] intervals) {

    Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
    int[][] res = new int[intervals.length][2];
    int index = -1;
    for (int i = 0; i < intervals.length; i++) {
      if(index == -1 || res[index][1] < intervals[i][0]){
        res[++index] = intervals[i];
      }else{
        res[index][1] = Math.max(res[index][1], intervals[i][1]);
      }
    }

    return Arrays.copyOf(res,index+1);
  }

  public static void main(String[] args) {
    int[][] test = {{8, 10}, {1, 3}, {15, 18}, {2, 6}};
    merge(test);
  }
}
