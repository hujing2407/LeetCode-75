package Easy.String;

import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Dec. 01 2023
 */
public class JewelsAndStones771 {
  public int numJewelsInStones(String jewels, String stones) {
    boolean[] isJewel = new boolean[256];
    for(char j: jewels.toCharArray()) isJewel[j] = true;
    int res = 0;
    for(char s: stones.toCharArray()) {
      if(isJewel[s]) res++;
    }
    int a = jewels.indexOf('a');
    return res;
  }
}
