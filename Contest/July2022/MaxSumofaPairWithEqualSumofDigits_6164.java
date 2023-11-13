package July2022;

import java.util.HashMap;

/**
 * @author Jing Hu
 * @date Jul 16 2022
 */
public class MaxSumofaPairWithEqualSumofDigits_6164 {
    public int maximumSum(int[] nums) {
        int result = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            int sumOfDigit = 0;
            int temp = num;
            do {
                sumOfDigit += temp % 10;
                temp /= 10;
            } while (temp != 0);

            if (hashMap.containsKey(sumOfDigit)) {
                result = result > (num + hashMap.get(sumOfDigit)) ? result : (num + hashMap.get(sumOfDigit));
                if(hashMap.get(sumOfDigit)<num){
                    hashMap.put(sumOfDigit,num);
                }
            }else{
                hashMap.put(sumOfDigit,num);
            }
        }

        return result;
    }
}
