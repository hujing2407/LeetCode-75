package Medium.String;

import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Mar 12 2021
 */
public class ContainsAllBinaryCodes1461 {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() <= k) return false;

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length()-k; i++) {
            set.add(s.substring(i,i+k));
        }
        return set.size()==(1<<k);
    }

    // lost efficiency
    public boolean hasAllCodes1(String s, int k) {
        int num = (int) Math.pow(2, k);
        for (int i = 0; i < num; i++) {
            String s1 = Integer.toBinaryString(i);
            if (s1.length() < k) {
                for (int j = 0; j < k - s1.length(); j++) {
                    s1 = "0" + s1;
                }
            }
            if (!s.contains(s1)) {
                return false;
            }
        }
        return true;
    }
}
