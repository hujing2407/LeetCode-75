package Easy;
import java.util.Arrays;

public class RunningSumof1dArray {
        public int[] runningSum(int[] nums) {
            int[] res = new int[nums.length];
            res[0] = nums[0];
            for(int i=1;i<nums.length;++i){
                res[i] = res[i-1]+nums[i];
            }
            return res;
                   
        }
        
        /**
         * @param args
         */
        public static void main(String[] args) {
            int[] nums = {1,2,3,4};
            RunningSumof1dArray res = new RunningSumof1dArray();
            
    
            // System.out.println("Hello World!");
            System.out.println(Arrays.toString(res.runningSum(nums)));
            
           
            
    
        }
       
}
