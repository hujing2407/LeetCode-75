package ValidParentheses;

import java.util.Stack;

/**
 * @author Jing Hu
 * @date Feb 09 2021
 */
class Solution {
    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' ||chars[i] == '[' ||chars[i] == '{' ){
                stack.add(chars[i]);
            }else if(chars[i] == ')' ){
                if(!stack.isEmpty() && stack.pop() == '(') {
                }else{
                    return false;

                }
            }else if(chars[i] == ']' ){
                if(!stack.isEmpty() && stack.pop() == '[') {
                }else{
                    return false;
                }
            }else if(chars[i] == '}' ){
                if(!stack.isEmpty() && stack.pop() == '{') {
                }else{
                    return false;

                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }
}

