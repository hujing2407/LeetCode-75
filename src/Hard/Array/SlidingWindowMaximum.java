package Hard.Array;

import java.util.*;

/**
 * @author Jing Hu
 * @date Sep. 04 2023
 */
public class SlidingWindowMaximum {

  public class MyComparator implements Comparator<Integer>
  {
    public int compare( Integer x, Integer y )
    {
      return y - x;
    }
  }

  public static void main(String[] args) {
    int[] nums = {1,3,-1,-3,5,3,6,7};
    SlidingWindowMaximum maximum = new SlidingWindowMaximum();
    maximum.maxSlidingWindow(nums,3);
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length - k + 1;
    if(n<1) return null;
    int[] res = new int[n];
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int resIndex = 0;

    for (int i = 0; i < nums.length; i++) {
      while(!deque.isEmpty() && deque.peek() < i-k+1){
        deque.poll();
      }
      while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
        deque.pollLast();
      }
      deque.addLast(i);
      if (i >= k-1) {

        res[resIndex++] = nums[deque.peek()];
      }
    }

    return res;
  }

}
