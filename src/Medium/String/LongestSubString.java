package Medium.String;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jing Hu
 * @date Jan 26 2021
 */
class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        String lss = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int indexOf = lss.indexOf(chars[i]);
            if (indexOf == -1){
                lss = lss + chars[i];
            }else {
                i = i - (lss.length()-indexOf -1);
                lss = lss.substring(indexOf);
                lss = ""+chars[i];
            }
            longest = Math.max(longest,lss.length());
        }
        return longest;
    }
}
