package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jing Hu
 * @date Dec. 03 2023
 */
public class FindAllAnagrams438 {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length(), plen = p.length();
        ArrayList<Integer> res = new ArrayList<>();
        if (s == null || p == null || slen == 0 ||
            plen == 0 || slen < plen) return res;

        int[] need = new int[26], window = new int[26];
        for (int i = 0; i < plen; i++) {
            need[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(need, window)) res.add(0);
        for (int i = 0; i < slen - plen; i++) {
            window[s.charAt(i) - 'a']--;
            window[s.charAt(i+plen) - 'a']++;
            if (Arrays.equals(need, window)) res.add(i+1);
        }
        return res;
    }

}
