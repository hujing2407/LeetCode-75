package Easy.Array;

/**
 * @author Jing Hu
 * @date Nov. 23 2023
 */
public class RelativeSortArray1122 {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] cnt = new int[1001];
    for (int a : arr1) ++cnt[a];

    int[] res = new int[arr1.length];
    int i = 0;
    for (int a2 : arr2) {
      while (cnt[a2]-- > 0) {
        res[i++] = a2;
      }
    }

    for (int j = 0; j < cnt.length; ++j) {
      while (cnt[j]-- > 0) res[i++] = j;
    }

    return res;
  }
}
