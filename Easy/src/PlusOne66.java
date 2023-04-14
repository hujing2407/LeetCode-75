/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 41.3 MB
 * Beats
 * 18.85%
 *
 * @author Jing Hu
 * @date Apr. 14 2023
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {

        int rear = digits.length-1 ;
        while(rear >= 0 && digits[rear] == 9){
            digits[rear] = 0;
            rear--;
        }

        if (rear == -1) {
            int newDigits[] = new int[digits.length+1];
            newDigits[0]=1;
            digits = newDigits;
        }else{
            digits[rear] += 1;
        }

        return digits;
    }

}
