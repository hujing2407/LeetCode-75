package Easy.String;

/**
 * @author Jing Hu
 * @date May 09 2023
 */
public class RepeatedSubstringPattern459 {
  public boolean repeatedSubstringPattern(String str) {
    int len =  str.length();
    for (int i = len/2; i >0 ; i--) {
      if (len%i == 0) {
        int times = len/i;
        String sub = str.substring(0,i);
        int j;
        for (j = 1; j < times; j++) {
          if (!sub.equals(str.substring(j*i,j*i +i))) {
            break;
          }
        }
        if (j == times) {
          return true;
        }

      }
    }
    return false;
  }
}
