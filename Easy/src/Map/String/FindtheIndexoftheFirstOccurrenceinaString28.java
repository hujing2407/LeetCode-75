package Map.String;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 40.6 MB
 * Beats
 * 56.9%
 *
 * @author Jing Hu
 * @date Apr. 14 2023
 */
public class FindtheIndexoftheFirstOccurrenceinaString28 {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        int tlen = haystack.length();
        for (int i = 0; i < tlen-len+1; i++) {
            if (needle.equals(haystack.substring(i,i+len))) {
                return i;
            }
        }

        return -1;
    }
}
