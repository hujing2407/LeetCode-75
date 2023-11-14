package Feb16.LetterCasePermutation;

import java.util.List;

/**
 * @author Jing Hu
 * @date Feb 16 2021
 */
public class Test {
    public static void main(String[] args) {
        String s="a1B2";
        Solution solution = new Solution();
        List<String> stringList = solution.letterCasePermutation(s);
        for (String x:stringList             ) {
            System.out.println(x);
        }

    }
}
