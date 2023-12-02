package Medium.Array;

import java.util.HashSet;

/**
 * @author Jing Hu
 * @date Mar 13 2021
 */
public class ProductofArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length==0) return null;
        int len = nums.length;
        int[] ints = new int[len];
        int r = 1;
        ints[0] = 1;
        for (int i = 1; i < len; i++) {
            ints[i] = nums[i - 1] * ints[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            ints[i] = ints[i]*r;
            r = r*nums[i];
        }
        return ints;
    }

    // use three array: 1. left product 2. right product 3. final product value
    public int[] productExceptSelf1(int[] nums) {
        if (nums.length==0) return null;
        int len = nums.length;
        int[] ints = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        for (int i = 0; i < len; i++) {
            ints[i] = left[i] * right[i];
        }
        return ints;
    }

    public int[] allProductExceptSelf(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int k = nums.length;
        int bin = (int) Math.pow(2, k);
        for (int i = 0; i < bin; i++) {
            int pro = 1;
            int bit = i + 1;
            for (int j = 0; j < k; j++) {
                if (bit % 2 == 1) {
                    pro *= nums[j];
                }
                bit = bit >>> 1;
            }
            hashSet.add(pro);
        }

        for (int i = 0; i < nums.length; i++) {
            hashSet.remove(nums[i]);
        }

        int[] ints = new int[hashSet.size()];
        int index = 0;
        for (int i : hashSet) {
            ints[index] = i;
            index++;
        }
        return ints;
    }
}
