package Array;

/**
 * @author Jing Hu
 * @date Aug. 16 2023
 */
public class SetMismatch645 {
  public int[] findErrorNums(int[] nums) {
    boolean[] visited = new boolean[10001];
    int duplicated = 0, sum = 0, n = nums.length;
    for (int num : nums) {
      if(visited[num]) duplicated = num;
      visited[num] = true;
      sum += num;
    }
    return new int[]{duplicated,(n*(n+1)/2 - sum + duplicated)};
  }
}
