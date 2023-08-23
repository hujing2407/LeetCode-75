package String;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 * Memory
 * 40.5 MB
 * Beats
 * 63%
 *
 * @author Jing Hu
 * @date Aug. 15 2023
 */
public class StudentAttendanceRecordI551 {
  public static boolean checkRecord(String s) {

    int totalA = 0;
    int i = 0;
    while (i < s.length()) {
      int consecutiveL = 0;
      switch (s.charAt(i)) {
        case 'A':
          totalA++;
          if (totalA > 1) return false;
          break;
        case 'L':
          consecutiveL++;
          i++;
          while (i < s.length() && s.charAt(i) == 'L') {
            consecutiveL++;
            i++;
          }
          if (consecutiveL >= 3) return false;
          i--;
          break;
      }
      i++;
    }

    return true;
  }

  public static void main(String[] args) {
    String s = "PPALLP";
    boolean b = checkRecord(s);
    System.out.println(b);

  }
}
