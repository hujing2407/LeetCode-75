package Array;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @author Jing Hu
 * @date Mar 12 2021
 */
public class LargestRectangleInHistogram_84_1 {
    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        // verify some special cases
        if (len == 0) return 0;
        if (len == 1) return heights[0];

        // create a new array: set head and tail sentinal values 0
        int[] newArr = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newArr[i + 1] = heights[i];
        }

        // prepare useful variables
        int area = 0;
        len += 2;
        Deque<Integer> stack = new ArrayDeque<Integer>();

        // push and pop stack
        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && newArr[i] < newArr[stack.peekLast()]) {
                int h = newArr[stack.removeLast()];

                int width = i - stack.peekLast() - 1;

                area = Math.max(area, h * width);
            }
            stack.add(i);
        }

        return area;
    }
}
