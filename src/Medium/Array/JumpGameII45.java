package Medium.Array;

/**
 * @author Jing Hu
 * @date Jan. 09 2024
 */
public class JumpGameII45 {
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];
        for(int i = 0;i<steps.length; i++) steps[i] = Integer.MAX_VALUE;
        steps[0]=0;
        for(int i = 0;i<steps.length; i++){
            for(int j = 1; j<=nums[i] && i+j<steps.length; j++){
                steps[i+j] = Math.min(steps[i+j], steps[i]+1);
                if(i+j == steps.length -1) return steps[i+j];
            }
        }
        return steps[steps.length-1];
    }

    public static void main(String[] args) {
        JumpGameII45 j = new JumpGameII45();
        int[] nums = {2,3,1,1,4};
        System.out.println(j.jump(nums));
    }
}
