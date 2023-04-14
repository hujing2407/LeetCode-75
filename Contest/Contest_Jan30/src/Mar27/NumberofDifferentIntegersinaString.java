package Mar27;

import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Mar 27 2021
 */
public class NumberofDifferentIntegersinaString {
    public int numDifferentIntegers(String word) {
        HashSet<String> set = new HashSet<>();

        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String num = "";

            while (i < chars.length && Character.isDigit(chars[i])) {
                num = num + chars[i];
                i++;
            }
            while (num.length() > 1 && num.indexOf('0') == 0) {
                num = num.substring(1);
            }
            if (num.length() != 0) {
                set.add(num);
            }
        }
        return set.size();
    }
}
