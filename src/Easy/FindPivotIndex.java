package Easy;
class FindPivotIndex{
    public int pivotIndex(int[] nums) {
        if(nums.length==0) return -1;
        int sum = 0;
        int leftSum, rightSum;
        for(int element : nums) { 
            sum += element;       
        }

        leftSum = 0;
        rightSum = sum;

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }
        
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex f =new FindPivotIndex();
        int[] a = {1,7,3,6,5,6};
        System.out.println(f.pivotIndex(a));
    }
}