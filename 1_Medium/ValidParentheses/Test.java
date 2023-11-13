package ValidParentheses;

/**
 * @author Jing Hu
 * @date Feb 09 2021
 */
public class Test {
    public static void main(String[] args) {

        String s = "{ { ( { } ) } }";
//        String s = "[";


        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }
}
