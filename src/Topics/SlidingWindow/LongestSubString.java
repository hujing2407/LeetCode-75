package Topics.SlidingWindow;

/**
 * @author Jing Hu
 * @date Jan 26 2021
 */
public class LongestSubString {
    public int lengthOfLongestSubstring1(String s) {
        int longest = 0;
        String lss = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int indexOf = lss.indexOf(chars[i]);
            if (indexOf == -1) {
                lss = lss + chars[i];
            } else {
                i = i - (lss.length() - indexOf - 1);
                lss = lss.substring(indexOf);
                lss = "" + chars[i];
            }
            longest = Math.max(longest, lss.length());
        }
        return longest;
    }

    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int l = 0, r = 0;
        int[] window = new int[128];

        while (r < s.length()) {
            char chr = s.charAt(r);
            r++;
            window[chr]++;
            while (l < s.length() && window[chr] > 1) {
                char chl = s.charAt(l);
                l++;
                window[chl]--;
            }
            longest = Math.max(longest, r - l);
        }
        return longest;
    }
}
