package Easy.String;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Jing Hu
 * @date Feb 09 2021
 */
class ValidParentheses20 {
  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == '(')
        stack.push(')');
      else if (c == '{')
        stack.push('}');
      else if (c == '[')
        stack.push(']');
      else if (stack.isEmpty() || stack.pop() != c)
        return false;
    }

    return stack.isEmpty();
  }
}

