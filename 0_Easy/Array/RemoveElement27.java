package Array;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 41 MB
 * Beats
 * 59.44%
 *
 * @author Jing Hu
 * @date Apr. 13 2023
 */
public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int index = 0;
        int rear = nums.length - 1;
        while (index <= rear) {
            while (rear >= 0 && nums[rear] == val) {
                rear--;
            }
            if(rear < index) break;
            if(rear == index) {
                index++;
                break;
            }
            while (index < rear && nums[index] != val) {
                index++;
            }

            if (index < nums.length && rear >=0 && index < rear) {
                int temp = nums[index];
                nums[index] = nums[rear];
                nums[rear] = temp;
                index++;
                rear--;
            }
        }

        return index;
    }
}
