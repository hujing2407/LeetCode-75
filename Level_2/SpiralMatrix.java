package Level_2;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    /**
     * Success
     * Details
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral
     * Matrix.
     * Memory Usage: 42 MB, less than 58.04% of Java online submissions for Spiral
     * Matrix.
     * Next challenges:
     * Spiral Matrix II
     * Spiral Matrix III
     * Spiral Matrix IV
     * Show off your acceptance:
     * Time Submitted
     * Status
     * Runtime
     * Memory
     * Language
     * 08/20/2022 12:12 Accepted 0 ms 42 MB java
     * 
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new LinkedList<>();
        if (matrix[0].length == 0) {
            return ls;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int index = left; index <= right; ++index) {
                ls.add(matrix[top][index]);
            }
            ++top;
            if (top > bottom)
                break;

            for (int index = top; index <= bottom; ++index) {
                ls.add(matrix[index][right]);
            }
            --right;
            if (left > right)
                break;

            for (int index = right; index >= left; --index) {
                ls.add(matrix[bottom][index]);
            }
            --bottom;
            if (top > bottom)
                break;

            for (int index = bottom; index >= top; --index) {
                ls.add(matrix[index][left]);
            }
            ++left;
            if (left > right)
                break;
        }

        return ls;
    }
}
