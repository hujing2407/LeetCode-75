package Easy.String;

/**
 * @author Jing Hu
 * @date Aug. 15 2023
 */
public class DetectCapital520 {
  public boolean detectCapitalUse(String word) {
    int size = word.length();
    if (size == 1) return true;
    if (Character.isUpperCase(word.charAt(0))){
      if (size == 2) return true;

      boolean isSecondCapital = Character.isUpperCase(word.charAt(1));

      for (int i = 2; i < size; i++) {
          if(isSecondCapital != Character.isUpperCase(word.charAt(i))) return false;
        }

    }else{
      for (int i = 1; i < size; i++) {
        if(Character.isUpperCase(word.charAt(i))) return false;
      }
    }

    return true;
  }
}
