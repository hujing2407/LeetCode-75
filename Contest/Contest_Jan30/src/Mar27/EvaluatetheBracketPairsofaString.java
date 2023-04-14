package Mar27;

import java.util.*;

/**
 * @author Jing Hu
 * @date Mar 27 2021
 */
public class EvaluatetheBracketPairsofaString {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> l:knowledge) {
            map.put(l.get(0), l.get(1));
        }

        Deque<Character> stack = new ArrayDeque<Character>();
        char[] chars = s.toCharArray();
        String s1 ="";
        int count=0;
        while(count<chars.length){

            if(chars[count] =='('){
                String key = "";
                count++;
                while(chars[count]!=')'){
                    key+=chars[count];
                    count++;
                }
                String value = map.get(key);
                if(value==null){
                    s1 +="?";
                }else{
                    s1+=value;
                }
            }else{
                s1+=chars[count];
            }
            count++;
        }

        return s1;
    }
}
