package Easy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Jing Hu
 * @date Aug. 25 2023
 */
public class ShuffleAnArray {

  private int[] ori = null;
  private int[] shuffled = null;
  private int size = 0;
  private Random random = null;

  public ShuffleAnArray(int[] nums) {
    ori = nums.clone();
    size = nums.length;
    this.random = new Random();
  }

  public int[] reset() {
    return ori;
  }

  public int[] shuffle() {
    shuffled = new int[size];
    Arrays.fill(shuffled,Integer.MAX_VALUE);
    int i = 0;
    while(i<size){
      int index = random.nextInt(size);
      if (shuffled[index] == Integer.MAX_VALUE ) {
        shuffled[index] = ori[i];
        i++;
      }
    }

    return shuffled;
  }

  public int getRandomIndex(int start, int end) {
    int randomNumber = this.random.nextInt(end - start+1);
    return start + randomNumber;
  }




}
