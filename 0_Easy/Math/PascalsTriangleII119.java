package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 40.4 MB
 * Beats
 * 48.47%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class PascalsTriangleII119 {
  public List<Integer> getRow(int rowIndex) {
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < rowIndex+1; i++) {
      int res = 1;
      for (int j = 0; j < i; j++) {
        res *= (rowIndex-j);
        res /= (j+1);
      }
      list.add((int)res);
    }
    return list;
  }
}
