package Level_1;
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left <= right){
            if(nums[left] == target) return left;
            if(nums[right] == target) return right;
            mid = (left + right) /2;
            if(target > nums[mid]){
                left = mid+1;
            }else if(target < nums[mid]){
                right = mid-1;
            }else{
                return mid;
            }
        }
            
        return -1;            
    }
}
