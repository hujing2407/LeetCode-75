package Array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


/**
 * @author Jing Hu
 * @date Mar 12 2021
 */
public class LargestRectangleInHistogram_84 {
    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        // verify some special cases
        if (len == 0) return 0;
        if (len == 1) return heights[0];

        // prepare useful variables
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();

        // push and pop stack
        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int h = heights[stack.removeLast()];


                // when the bar has same height
                while (!stack.isEmpty() && heights[stack.peekLast()] == h) {
                    stack.removeLast();
                }

                int width = 0;

                // when the first still higher than next one, this one could extend to current index
                if (stack.isEmpty()){
                    width = i;
                }else{
                    width = i - stack.peekLast() -1;
                }

                area = Math.max(area, h * width);
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            int h = heights[stack.removeLast()];


            // when the bar height same
            while (!stack.isEmpty() && heights[stack.peekLast()] == h) {
                stack.removeLast();
            }

            int width = 0;
            // the last one, means this is the shortest. it could extend all range
            if (stack.isEmpty()){
                width = len;
            }else{  // it could extend to the end
                width = len - stack.peekLast() -1;
            }

            area = Math.max(area, h * width);
        }

        return area;
    }
}
