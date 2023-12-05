package Easy;
import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr =  t.toCharArray();
        HashMap<Character,Character> map1 = new HashMap<Character, Character>();
        HashMap<Character,Character> map2 = new HashMap<Character, Character>();
        
        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(sArr[i])) {
                if(map1.get(sArr[i]) == tArr[i]){
                    continue;
                }else{
                    return false;
                }
                
            }else{
                map1.put(sArr[i], tArr[i]);
            }

            if (map2.containsKey(tArr[i])) {
                if(map2.get(tArr[i]) == sArr[i]){
                    continue;
                }else{
                    return false;
                }
                
            }else{
                map2.put(tArr[i], sArr[i]);
            }
        }

        return true;
    }    
}
