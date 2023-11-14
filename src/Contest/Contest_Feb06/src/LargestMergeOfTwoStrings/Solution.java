package LargestMergeOfTwoStrings;

/**
 * @author Jing Hu
 * @date Feb 06 2021
 */
public class Solution {
    public String largestMerge(String word1, String word2) {


        char[] chars = new char[word1.length() + word2.length()];
        int i = 0;

        while (!word1.isEmpty() && !word2.isEmpty()){
            if(word1.compareTo(word2)>0){
                chars[i] = word1.toCharArray()[0];
                i++;
                word1 =  word1.substring(1);
            }else{
                chars[i] = word2.toCharArray()[0];
                i++;
                word2 = word2.substring(1);
            }
        }

        if(!word1.isEmpty()){
            char[] s1 = word1.toCharArray();
            for (int j = 0; j < word1.length(); j++) {
                chars[i] = s1[j];
                i++;
            }
        }else {
            char[] s2 = word2.toCharArray();
            for (int j = 0; j < word2.length(); j++) {
                chars[i] = s2[j];
                i++;
            }
        }

        String merge = String.valueOf(chars);

        return merge.toString();
    }


}
