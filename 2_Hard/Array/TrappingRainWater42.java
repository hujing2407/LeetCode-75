package Array;

/**
 * @author Jing Hu
 * @date Mar 12 2021
 */
public class TrappingRainWater42 {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int vol = 0;

        while (left < right) {
            if (height[left]<height[right]){
                // move left wall
                if(height[left]>leftMax){
                    leftMax = height[left];
                    left++;
                }else{ // this volume could be collected
                    vol = vol + (leftMax - height[left]);
                    left++;
                }
            }else{
                // move right wall
                if(height[right]>rightMax){
                    rightMax = height[right];
                    right--;
                }else{ // this volume could be collected
                    vol = vol + (rightMax - height[right]);
                    right--;
                }
            }
        }
        return vol;
    }
}
