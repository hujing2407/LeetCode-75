package RegularExpressionMatching;

/**
 * @author Jing Hu
 * @date Jan 27 2021
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        String s = "aa", p = "a"; //false
//        String s = "aaa", p = "ab*a*c*a"; // true
//        String s = "aaa", p = "aa*a"; //true
//        String s = "ab", p = ".*";//true

//        String s = "abcdefefeagbc", p = "a.*f.*bc";//true
//        String s = "aab", p = "c*a*b"; //true
//        String s = "mississippi", p = "mis*is*p*.";//false
//        String s = "bbbba", p = ".*a*a"; //true
//        String s = "a", p = "a*a";//true
//        String s = "aa", p = "a*a"; //true
        String s = "ab", p = ".*.."; //true

        boolean b = solution.isMatch(s,p);
        System.out.println(b);
//        String s = "abc*";
//        char[] chars = s.toCharArray();
//        System.out.println('*' == (chars[3]));
    }
}
