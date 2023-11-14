package String;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Jing Hu
 * @date Apr. 16 2023
 */
public class ValidAnagram242 {
  public boolean isAnagram(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i <s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        int num = map.get(s.charAt(i))+1;
        map.put(s.charAt(i),num);
      }else{
        map.put(s.charAt(i),1);
      }
    }
    for (int i = 0; i <t.length(); i++) {
      if (map.containsKey(t.charAt(i))) {
        int num = map.get(t.charAt(i))-1;
        map.put(t.charAt(i),num);
      }else{
        return false;
      }
    }
    
    AtomicBoolean isAnagram = new AtomicBoolean(true);
    map.forEach(
        (k, v) -> {
          isAnagram.set(isAnagram.get() & v.equals(0));
        }
    );
    return isAnagram.get();
  }
}
