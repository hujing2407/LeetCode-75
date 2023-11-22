package Medium.Array;

/**
 * @author Jing Hu
 * @date Nov. 21 2023
 */
public class SearchinRotatedSortedArray33 {
  public static int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1, m = 0;
    while (l <= r) {
      m = (l+r)/2;
      if (nums[m] == target) return m;
      if (nums[l] == target) return l;
      if (nums[r] == target) return r;

      if (nums[l] < nums[m]) { // left half sorted
        if (nums[l] < target && target < nums[m]) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      } else {
        if (nums[m] < target && target < nums[r]) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(search(new int[]{4,5,6,7,8,9,10,11,12,0,1,2}, 0));
  }
}
