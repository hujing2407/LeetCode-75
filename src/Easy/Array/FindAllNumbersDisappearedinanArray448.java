package Easy.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jing Hu
 * @date May 09 2023
 */
public class FindAllNumbersDisappearedinanArray448 {
  public List<Integer> findDisappearedNumbers(int[] nums) {

    ArrayList<Integer> list = new ArrayList<>();
    int[] index = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      index[nums[i]]++;
    }
    for (int i = 1; i < index.length; i++) {
      if (index[i] == 0) {
        list.add(i);
      }
    }
    return list;
  }
}
