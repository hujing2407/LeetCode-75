package Array;

/**
 * Runtime
 * 0 ms
 * Beats
 * 100%
 *
 * Memory
 * 40.1 MB
 * Beats
 * 56.79%
 *
 * @author Jing Hu
 * @date Apr. 15 2023
 */
public class ExcelSheetColumnTitle168 {
  public String convertToTitle(int columnNumber) {

    StringBuilder builder = new StringBuilder();
    while(columnNumber != 0){
      // Diff to Decimal, there is no Zero, all value from 1
      int i = (columnNumber-1) % 26;
      char title = (char) ('A'+i);
      builder.append(title);
      columnNumber = (columnNumber-1) /26;
    }
    return builder.reverse().toString();
  }
}
