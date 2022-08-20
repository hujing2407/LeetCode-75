package Level_1;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsString {
    /**
     * Not efficiency. Alternative method is using a moved window [26 chars]
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new LinkedList<>();
        int len = p.length();
        if(s.length()<len) return ls;
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);

        for (int i = 0; i < s.length()-len; i++) {
            String temp = s.substring(i, i+len);
            char[] subArr = temp.toCharArray();
            Arrays.sort(subArr);
            if (Arrays.equals(pArr, subArr)) {
                ls.add(i);
            }
        }

        return ls;
    }  
}
