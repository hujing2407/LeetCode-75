package Easy.String;

import java.util.HashMap;

/**
 * @author Jing Hu
 * @date Dec. 10 2023
 */
public class IsomorphicStrings205 {
    public boolean isIsomorphic(String s, String t) {
        int[] arrS = new int[128];
        int[] arrT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if(arrS[s.charAt(i)] != arrT[t.charAt(i)]) return false;
            arrS[s.charAt(i)] = i+1;
            arrT[t.charAt(i)] = i+1;
        }
        return true;
    }


    public boolean isIsomorphic1(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < sArr.length; i++) {
            if(map1.containsKey(sArr[i])){
                if(map1.get(sArr[i]) != tArr[i]) return false;}
            else map1.put(sArr[i],tArr[i]);
            if(map2.containsKey(tArr[i])){
                if(map2.get(tArr[i]) != sArr[i]) return false;}
            else map2.put(tArr[i],sArr[i]);
        }
        return true;
    }
}
