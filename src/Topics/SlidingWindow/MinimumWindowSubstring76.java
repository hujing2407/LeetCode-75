package Topics.SlidingWindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Jing Hu
 * @date Dec. 03 2023
 */
public class MinimumWindowSubstring76 {
    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();

    public String minWindow1(String s, String t) {

        if (s == null || t == null || s.length() == 0 ||
            t.length() == 0 || s.length() < t.length()) return new String();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1, ansL = -1, ansR = -1, len = s.length(), minLen = Integer.MAX_VALUE;

        while (r < len) {
            r++;
            if (r < len && need.containsKey(s.charAt(r))) {
                char add = s.charAt(r);
                window.put(add, window.getOrDefault(add, 0) + 1);
            }

            while (check() && l <= r) {
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    ansL = l;
                    ansR = l + minLen;
                }
                char remove = s.charAt(l);
                window.put(remove, window.getOrDefault(remove, 0) - 1);
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);

    }

    private boolean check() {
        Iterator<Map.Entry<Character, Integer>> it = need.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = it.next();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (window.getOrDefault(key, 0) != value) {
                return false;
            }
        }
        return true;
    }

    public String minWindow2(String s, String t) {
        if (s == null || t == null || s.length() == 0 ||
            t.length() == 0 || s.length() < t.length()) return new String();
        int[] need = new int[128], want = new int[128];
        for (char c : t.toCharArray()) need[c]++;
        char[] ss = s.toCharArray();
        int l = 0, r = -1, ansL = -1, ansR = -1, len = s.length(), minLen = Integer.MAX_VALUE;

        while (r++ < len) {
            if (r < len && need[ss[r]] > 0) want[ss[r]]++;
            while (check(need, want) && l <= r) {
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    ansL = l;
                    ansR = ansL + minLen;
                }
                want[ss[l++]]--;
            }
        }
        return ansL == -1?"":s.substring(ansL,ansR);
    }

    private boolean check(int[] need, int[] want) {
        for (int i = 0; i < need.length; i++) {
            if (need[i] > 0 && need[i] > want[i]) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0) counter--;
            map[c1]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        MinimumWindowSubstring76 m = new MinimumWindowSubstring76();
        System.out.println(m.minWindow(s, t));
    }

}
