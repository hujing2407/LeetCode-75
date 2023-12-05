package Easy;
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)  return true;
        if (t.length() == 0)  return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int tIndex = 0;
        for (int i = 0; i < sArr.length; i++) {
            while (tIndex<tArr.length) {
                if (tArr[tIndex] == sArr[i]) {
                    break;
                }
                ++tIndex;
            }
            if(tIndex == tArr.length && i < sArr.length) return false;
            ++tIndex;
        }
        return true;
    }   
}
