package Array;

/**
 * @author Jing Hu
 * @date Mar 13 2021
 */
public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {

        if (height.length==0) return 0;
        int left = 0;
        int right = height.length - 1;
        int lMax = left;
        int rMax = right;
        int area = (height.length - 1) * Math.min(height[left], height[right]);
        while (left < right) {

            if (height[left] < height[right]) {
                while (left < rMax && height[left] <= height[lMax]) {
                    left++;
                }
                lMax = left;
            } else {
                while (right > lMax && height[right] <= height[rMax]) {
                    right--;
                }
                rMax = right;
            }
            area = Math.max(area, (rMax - lMax) * Math.min(height[rMax], height[lMax]));
        }
        return area;
    }
}
