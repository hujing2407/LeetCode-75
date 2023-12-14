package Easy.Array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Jing Hu
 * @date Aug. 16 2023
 */
public class CanPlaceFlowers605 {
  public static boolean canPlaceFlowers(int[] flowerbed, int n) {
    int i = 0;
    int place = 0;
    int[] newbed = new int[flowerbed.length + 2];
    for (int j = 0; j < flowerbed.length; j++) {
      newbed[j+1] = flowerbed[j];
    }
    while (i < newbed.length){
      int empty = 0;
      while (i < newbed.length && newbed[i++] == 0) {
        empty++;
      }
      if (empty > 2) {
        place += (empty-1)/2;
      }
    }

    return place>=n;
  }

  public static void main(String[] args) {
    int[] flowerbed = {1,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,1};
    System.out.println(canPlaceFlowers(flowerbed, 1));
  }
}
