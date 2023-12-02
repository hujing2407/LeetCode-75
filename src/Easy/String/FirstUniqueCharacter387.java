package Easy.String;

/**
 * @author Jing Hu
 * @date Dec. 02 2023
 */
public class FirstUniqueCharacter387 {
  public static int firstUniqChar(String s) {
    int res = Integer.MAX_VALUE;
    for (char i = 'a'; i <= 'z'; i++) {
      int index = s.indexOf(i);
      if (index != -1 && index == s.lastIndexOf(i))
        res = Math.min(res,index);
    }
    return res==Integer.MAX_VALUE?-1:res;
  }

  public static void main(String[] args) {
    System.out.println(firstUniqChar("aabb"));
  }
}
