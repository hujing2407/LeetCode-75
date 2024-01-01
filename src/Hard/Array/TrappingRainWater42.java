package Hard.Array;

/**
 * @author Jing Hu
 * @date Mar 12 2021
 */
public class TrappingRainWater42 {
    public int trap(int[] h) {
        int left = 0, right = h.length - 1, leftMax = 0, rightMax = 0, vol = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, h[left]);
            rightMax = Math.max(rightMax, h[right]);
            if (leftMax < rightMax) {
                vol += leftMax - h[left++];
            } else {
                vol += rightMax - h[right--];
            }
        }
        return vol;
    }

    public int trap1(int[] h) {
        int len = h.length, l = 0, r = len - 1, res = 0;
        while (l < r) {
            if (h[l] < h[r]) {
                int idx = l;
                while (idx < r && h[idx] <= h[l]) {
                    res += h[l] - h[idx];
                    idx++;
                }
                l = idx;
            } else {
                int idx = r;
                while (idx > l && h[idx] <= h[r]) {
                    res += h[r] - h[idx];
                    idx--;
                }
                r = idx;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater42 t = new TrappingRainWater42();
        int[] nums = {5, 4, 1, 2};
        System.out.println(t.trap(nums));
    }
}
