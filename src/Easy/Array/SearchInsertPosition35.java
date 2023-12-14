package Easy.Array;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 42.2 MB
 * Beats
 * 36.92%
 *
 * @author Jing Hu
 * @date Apr. 14 2023
 */
public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        int front = 0;
        int rear = nums.length-1;
        int mid = (front+rear)/2;

        if (target <nums[front]) {
            return front;
        }
        if (target >nums[rear]) {
            return rear;
        }

        while(front <= rear){
            mid = (front+rear)/2;
            if (target == nums[mid]) {
                return mid;
            }else if (target <nums[mid]) {
                rear = mid -1 ;
            }else{
                front = mid +1 ;
            }
        }
        return nums[mid]>target?mid:mid+1;
    }
}
