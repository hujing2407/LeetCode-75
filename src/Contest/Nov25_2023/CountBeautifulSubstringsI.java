package Contest.Nov25_2023;

import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Nov. 25 2023
 */
public class CountBeautifulSubstringsI {
  public int beautifulSubstrings1(String s, int k) {
    HashSet<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      int vows = 0, consonants = 0;
      for (int j = i; j < s.length(); j++) {
        if (set.contains(s.charAt(j))) vows++;
        else consonants++;
        if (vows == consonants && vows * consonants != 0 && vows * consonants % k == 0)
          cnt++;
      }
    }
    return cnt;
  }

  public long beautifulSubstrings(String s, int k) {
    HashSet<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');

    int vows = 0, consonants = 0, cnt = 0;
    for (char c : s.toCharArray()) {
      if (set.contains(c)) vows++;
      else consonants++;
    }



    return cnt;
  }
}
