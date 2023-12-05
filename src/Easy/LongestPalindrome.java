package Easy;
import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int len = 0;
        int flag = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        for (HashMap.Entry<Character, Integer> entry  : map.entrySet()) {
            if (entry.getValue()%2 == 0) {
                len += entry.getValue();
            } else {
                len += (entry.getValue()-1);
                flag = 1;
            }
        }
        return len+flag;
    }
}
