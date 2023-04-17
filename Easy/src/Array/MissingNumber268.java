package Array;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 43.5 MB
 * Beats
 * 31.96%
 *
 * @author Jing Hu
 * @date Apr. 17 2023
 */
public class MissingNumber268 {
  public int missingNumber(int[] nums) {
    int sum = 0;
    for (int i: nums
         ) {
      sum += i;
    }
    int n = nums.length;
    int diff = n*(n+1)/2 - sum;
    return diff;
  }
}

class NumArray {
  int[] n;
  public NumArray(int[] nums) {
    n=new int[nums.length];
    n[0]=nums[0];
    for(int i=1;i<nums.length;i++){
      n[i]=nums[i]+n[i-1];
    }
  }

  public int sumRange(int left, int right) {
    if(left==0){
      return n[right];
    }
    else{
      return n[right]-n[left-1];
    }
  }
}