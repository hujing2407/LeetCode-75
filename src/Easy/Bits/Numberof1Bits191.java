package Bits;

/**
 * Runtime
 * 1 ms
 * Beats
 * 43.27%
 *
 * Memory
 * 40.1 MB
 * Beats
 * 22.83%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class Numberof1Bits191 {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int count=0;
    while(n!=0){
      n=n &(n-1);
      count++;
    }
    return count;
  }
}
