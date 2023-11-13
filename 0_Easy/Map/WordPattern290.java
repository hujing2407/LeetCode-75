package Map;

import java.util.HashMap;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 40.6 MB
 * Beats
 * 37.80%
 *
 * @author Jing Hu
 * @date Apr. 17 2023
 */
public class WordPattern290 {
  public boolean wordPattern(String pattern, String s) {
    char c[] = pattern.toCharArray();
    String sub[] = s.split(" ");

    if (c.length != sub.length) {
      return false;
    }
    HashMap<Character, String> map1 = new HashMap<>();
    HashMap<String, Character> map2 = new HashMap<>();
    for (int i = 0; i < c.length; i++) {
      if (map1.containsKey(c[i])) {
        if (!map1.get(c[i]).equals(sub[i])) {
          return false;
        }
      }else{
        map1.put(c[i],sub[i]);
      }
      if (map2.containsKey(sub[i])) {
        if (!map2.get(sub[i]).equals(c[i])) {
          return false;
        }
      }else{
        map2.put(sub[i],c[i]);
      }
    }

    return true;
  }
}
