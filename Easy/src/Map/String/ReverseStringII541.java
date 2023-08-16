package Map.String;

/**
 * @author Jing Hu
 * @date Aug. 15 2023
 */
public class ReverseStringII541 {
  public static String reverseStr(String s, int k) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < s.length()/(k); i++) {
      if (i%2 == 0) {
        for (int j = k*(i+1)-1; j >= k*i; j--) {
          builder.append(s.charAt(j));
        }
      }else {
        for (int j = k*(i); j < k*(i+1); j++) {
          builder.append(s.charAt(j));
        }
      }
    }
    if (s.length()/(k) %2 == 0 ) {
      for (int j = s.length()-1; j >= s.length()/(k)*k; j--) {
        builder.append(s.charAt(j));
      }
    }else{
      builder.append(s.substring(s.length()/(k)*k,s.length()));
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    String a = "onetwothree";
    String reverseStr = reverseStr(a, 3);
    System.out.println(reverseStr);
  }
}
