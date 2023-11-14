package Bits;

/**
 * @author Jing Hu
 * @date May 10 2023
 */
public class NumberComplement476 {
  public int findComplement(int num) {
    int n = num;
    int bits = 0;
    while(n!=0) {
      n = n>>1;
      bits++;
    }
    int mask = (1<<bits) -1;

    return num^mask;
  }
}
