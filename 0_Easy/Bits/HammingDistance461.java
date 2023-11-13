package Bits;

/**
 * @author Jing Hu
 * @date May 09 2023
 */
public class HammingDistance461 {
  public int hammingDistance(int x, int y) {
    int distance = 0;
    int res = x^y;

    while (res != 0){
      res &= (res-1);
      distance++;
    }
    return distance;
  }
}
