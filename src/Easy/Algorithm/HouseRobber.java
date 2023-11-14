package Algorithm;

/**
 * @author Jing Hu
 * @date Sep. 03 2023
 */
public class HouseRobber {
  // public int rob(int[] num) {
//     int rob = 0; //max monney can get if rob current house
//     int notrob = 0; //max money can get if not rob current house
//     for(int i=0; i<num.length; i++) {
//         int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
//         notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
//         rob = currob;
//     }
//     return Math.max(rob, notrob);
// }

  public static int rob(int[] nums) {
    if(nums.length==0) return 0;
    if(nums.length==1) return nums[0];

    //Initialize an arrays to store the money
    int[] mark = new int[nums.length];

    //We can infer the formula from problem:mark[i]=max(num[i]+mark[i-2],mark[i-1])
    //so initialize two nums at first.
    mark[0] = nums[0];
    mark[1] = Math.max(nums[0], nums[1]);

    //Using Dynamic Programming to mark the max money in loop.
    for(int i=2;i<nums.length;i++){
      mark[i] = Math.max(nums[i]+mark[i-2], mark[i-1]);
    }
    return mark[nums.length-1];
  }

  public static void main(String[] args) {
    int[] nums = {2,7,9,3,1};
    int rob = rob(nums);

  }
}
