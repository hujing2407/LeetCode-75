/**
 * @author Jing Hu
 * @date Apr. 13 2023
 */
public class PalindromeNumber_09 {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        int len = num.length();
        for (int i = 0; i < len/2+1; i++) {
            if(num.charAt(i) != num.charAt(len-i-1)) return false;
        }
        return true;
    }
}
