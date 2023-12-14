package Easy.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Jing Hu
 * @date Aug. 14 2023
 */
public class RelativeRanks506 {
  public String[] findRelativeRanks(int[] score) {
    int n = score.length;
    String[] strings = new String[n];
    int[] ints = Arrays.copyOf(score, n);

    Arrays.sort(ints);

    HashMap<Integer, String> relatives = new HashMap<>();

    if(n == 1) {
      strings[0] = "Gold Medal";
      return strings;
    }

    if(n == 2){
      strings[1] = "Gold Medal";
      strings[0] = "Silver Medal";
      return strings;
    }

    relatives.put(ints[n - 1], "Gold Medal");
    relatives.put(ints[n - 2], "Silver Medal");
    relatives.put(ints[n - 3], "Bronze Medal");

    for (int i = 0; i < n -3; i++) {
      relatives.put(ints[i], String.valueOf(n-i));
    }

    for (int i = 0; i < score.length; i++) {
      strings[i] = relatives.get(score[i]);
    }

    return strings;
  }
}
