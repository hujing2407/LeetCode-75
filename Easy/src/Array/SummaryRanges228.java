package Array;

import java.util.ArrayList;
import java.util.List;

/**
 Runtime
 5 ms
 Beats
 78.93%

 Memory
 40.6 MB
 Beats
 86.92%
 *
 * @author Jing Hu
 * @date Apr. 16 2023
 */
public class SummaryRanges228 {
  public List<String> summaryRanges(int[] nums) {
    ArrayList<String> list = new ArrayList<>();

    int index = 0;
    while (index < nums.length) {
      int start = nums[index] ;
      while (index < nums.length - 1 && nums[index + 1] == nums[index] + 1) index++;
      int end = nums[index];
      if (start==end)
        list.add(""+start);
      else
        list.add(""+start + "->" + end);
      index++;
    }

    return list;
  }
}
