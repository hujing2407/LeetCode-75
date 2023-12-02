package Easy.String;

/**
 * @author Jing Hu
 * @date Dec. 01 2023
 */
public class ToLowerCase709 {
  public String toLowerCase(String s) {
    char[] chars = s.toCharArray();
    for(int i = 0; i<chars.length;i++){
      if(chars[i] >= 'A' && chars[i] <= 'Z')
        chars[i] += ('a'- 'A');
    }
    return new String(chars);
  }
}
