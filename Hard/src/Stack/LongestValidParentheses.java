package Stack;

import java.util.*;

/**
 * @author Jing Hu
 * @date Apr 03 2021
 */
public class LongestValidParentheses {

    //    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int longestValidParentheses(String s) {
        int num = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.add(-1); // Important, Add the initiate bottom index
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) =='('){
                stack.add(i);
            }else {
                stack.removeLast();
                if(stack.isEmpty()){
                    // cut off previous index
                    stack.add(i);
                }else{
                    num = Math.max(num, i-stack.getLast());
                }
            }
        }
        return num;
    }

    public int longestValidParentheses1(String s) {
        int num = 0;
        if (s.length() < 2) return 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        stack.add(chars[0]);
        for (int i = 1; i < s.length(); i++) {
            stack.add(chars[i]);
            if (chars[i] == ')') {
                num = Math.max(num, lengthOfStack(stack));
            }
        }
        return num;
    }

    public int lengthOfStack(ArrayDeque<Character> stack) {
        ArrayDeque<Character> stackR = new ArrayDeque<>();
        ArrayDeque<Character> stackL = stack.clone();
        int count = 0;
        char cur;
        while (!stackL.isEmpty()) {
            cur = stackL.removeLast();
            if (cur == ')') {
                stackR.add(cur);
            } else {
                if (stackR.isEmpty()) {
                    break;
                } else {
                    stackR.removeLast();
                    count += 2;
                }
            }
        }
        return count;
    }

}

