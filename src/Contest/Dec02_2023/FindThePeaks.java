package Contest.Dec02_2023;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jing Hu
 * @date Dec. 02 2023
 */
public class FindThePeaks {
  public static List<Integer> findPeaks(int[] mountain) {
    ArrayList<Integer> list = new ArrayList<>();
    if (mountain == null || mountain.length < 3) return list;
    int idx = 0;
    for (int i = 1; i < mountain.length - 1; i++) {
      if(mountain[i] > mountain[i-1] && mountain[i]>mountain[i+1]) list.add(i);
    }
    return list;
  }

  public static void main(String[] args) {
    int[] a = {1,4,3,8,5};
    System.out.println(findPeaks(a));
  }
}
