package Easy.Array;

/**
 * @author Jing Hu
 * @date Nov. 15 2023
 */
public class LemonadeChange860 {
  public boolean lemonadeChange(int[] bills) {
    int fives = 0, tens = 0;
    for (int bill : bills) {
      if (bill == 5) fives++;
      else if (bill == 10) {
        fives--;
        tens++;
      } else {
        tens--;
        fives--;
        if (tens < 0) {
          fives -= 2;
          tens++;
        }
      }

      if (fives < 0) return false;
    }
    return true;
  }
}
