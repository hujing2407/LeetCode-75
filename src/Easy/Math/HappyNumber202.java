package Easy.Math;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber202 {
    
    public boolean isHappy(int n) {
        int sum = 0;
        int num = n;
        int bit = 0;
        Set<Integer> set = new HashSet<Integer>();

        while (set.add(sum)) {
            sum = 0;
            while (num > 0) {
                bit = num % 10;
                sum = sum + bit * bit;
                num = num /10;
            }
            if (sum == 1) {
                return true;
            } else {
                num = sum;
            }
        }
        return false;
    } 
}
