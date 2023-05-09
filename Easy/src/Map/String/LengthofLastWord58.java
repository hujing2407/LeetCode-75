package Map.String;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 40.6 MB
 * Beats
 * 79.99%
 *
 * @author Jing Hu
 * @date Apr. 14 2023
 */
public class LengthofLastWord58 {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') index--;
        int rear = index;
        while (index >= 0 && s.charAt(index)!=' ') index--;
        return rear - index;
    }
}
