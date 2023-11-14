package Mar27;

/**
 * @author Jing Hu
 * @date Mar 27 2021
 */
public class MinimumNumberofOperationstoReinitializeaPermutation {
    public int reinitializePermutation(int n) {
        int count = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }

        do {
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = nums[i / 2];
                } else {
                    arr[i] = nums[n / 2 + (i - 1) / 2];
                }
            }
            nums = arr;
            count++;
        } while (!isInitialize(nums));

        return count;
    }

    public boolean isInitialize(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
