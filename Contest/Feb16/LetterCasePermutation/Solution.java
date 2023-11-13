package Feb16.LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jing Hu
 * @date Feb 16 2021
 */
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ls = new ArrayList<String>();
        int[] index = new int[s.length()];

        char[] chars = s.toCharArray();

        // confirm the characters location
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                index[i] = 1;
            } else if (chars[i] >= 97 && chars[i] <= 122) {
                index[i] = 1;
                chars[i] = (char) (chars[i] - 32);
            }
        }
        System.out.println(chars);
        // if there are no character in String

        // enumerate all String forms
        int i = 0;
        addToList(ls, chars, index, i);

        return ls;
    }

    private void addToList(List<String> ls, char[] chars, int[] index, int ind) {
        if (ind == index.length) {
            String str = new String(chars);
            ls.add(str);
            return;
        } else if (index[ind] == '1') {
            addToList(ls, chars, index, ++ind);
            chars[index[ind]] = (char) (chars[index[ind]] + 32);
            addToList(ls, chars, index, ++ind);
        } else {
            ind++;
        }
    }
}
