package LargestMergeOfTwoStrings;

/**
 * @author Jing Hu
 * @date Feb 06 2021
 */
public class Test {
    public static void main(String[] args) {
        String word1 = "abcabc";
        String word2 = "abdcaba";
        Solution solution = new Solution();
        String s = solution.largestMerge(word1, word2);
        System.out.println(s);
    }
}
